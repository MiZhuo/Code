package site.mizhuo.orderserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import site.mizhuo.orderserver.api.TimeFeignClient;
import site.mizhuo.orderserver.dao.IOrderDetailRepository;
import site.mizhuo.orderserver.dao.IOrderRepository;
import site.mizhuo.orderserver.entity.DO.LimitPolicyDO;
import site.mizhuo.orderserver.entity.DO.OrderDO;
import site.mizhuo.orderserver.entity.DO.OrderDetailDO;
import site.mizhuo.orderserver.entity.DTO.OrderDTO;
import site.mizhuo.orderserver.entity.DTO.OrderInfoDTO;
import site.mizhuo.orderserver.entity.DTO.SkuDetailDTO;
import site.mizhuo.orderserver.exception.SpikeException;
import site.mizhuo.orderserver.service.IOrderService;
import site.mizhuo.orderserver.utils.BeanConvertUtils;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @ClassName OrderServiceImpl
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 13:18
 * @Version 1.0
 **/
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    private static final String SKU_QUANTITY_ = "SKU_QUANTITY_";
    private static final String ORDER_QUEUE = "order_queue";

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IOrderDetailRepository orderDetailRepository;

    @Autowired
    TimeFeignClient feignClient;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    AmqpTemplate amqpTemplate;

    @Override
    public OrderDTO createOrderInfo(OrderDTO orderDTO) throws SpikeException {
        try {
            Long skuId = orderDTO.getSkuId();
            //1:??????????????????
            Object limitPolicy = redisTemplate.opsForValue().get("LIMIT_POLICY_" + skuId);
            if (limitPolicy != null) {
                //2:????????????????????????????????????????????????
                LimitPolicyDO limitPolicyDO = JSONObject.parseObject(limitPolicy.toString(), LimitPolicyDO.class);
                if (limitPolicyDO != null) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String now = feignClient.getTime();
                    Date beginTime = limitPolicyDO.getBeginTime();
                    Date endTime = limitPolicyDO.getEndTime();
                    Date nowTime = dateFormat.parse(now);
                    if (beginTime.getTime() <= nowTime.getTime() && nowTime.getTime() <= endTime.getTime()) {
                        Long limitQuantity = limitPolicyDO.getQuantity();
                        //3:??????Redis?????????
                        if(redisTemplate.opsForValue().increment(SKU_QUANTITY_ + skuId,1) <= limitQuantity){
                            //4:??????????????????
                            Object skuDetail = redisTemplate.opsForValue().get("SKU_" + orderDTO.getSkuId());
                            SkuDetailDTO skuDetailDTO = JSONObject.parseObject(skuDetail.toString(),SkuDetailDTO.class);
                            OrderInfoDTO orderInfoDTO = BeanConvertUtils.copyProperties(orderDTO,OrderInfoDTO.class);
                            Long orderId = System.currentTimeMillis();
                            orderInfoDTO.setOrderId(orderId);
                            orderInfoDTO.setTotalFee(skuDetailDTO.getPrice());
                            orderInfoDTO.setActualFee(limitPolicyDO.getPrice());
                            orderInfoDTO.setPostFee(0L);
                            orderInfoDTO.setPaymentType(false);
                            orderInfoDTO.setStatus(true);
                            orderInfoDTO.setCreateTime(new Timestamp(nowTime.getTime()));
                            orderInfoDTO.setNum(1);
                            orderInfoDTO.setTitle(skuDetailDTO.getTitle());
                            orderInfoDTO.setOwnSpec(skuDetailDTO.getOwnSpec());
                            orderInfoDTO.setPrice(skuDetailDTO.getPrice());
                            orderInfoDTO.setImages(skuDetailDTO.getImages());
                            try {
                                String orderStr = JSON.toJSONString(orderInfoDTO);
                                amqpTemplate.convertAndSend(ORDER_QUEUE,orderStr);
                            }catch (Exception e) {
                                throw new SpikeException("??????????????????!");
                            }
                            orderDTO.setOrderId(orderId);
                            return orderDTO;
                        }else{
                            throw new SpikeException("??????????????????!");
                        }
                    }else{
                        throw new SpikeException("???????????????!");
                    }
                }else{
                    throw new SpikeException("???????????????!");
                }
            }else{
                throw new SpikeException("???????????????!");
            }
        } catch (ParseException e) {
            throw new SpikeException("??????????????????!");
        }
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void addOrder(OrderInfoDTO orderInfoDTO) throws SpikeException {
        if(orderInfoDTO == null){
            throw new SpikeException("?????????????????????!");
        }
        try {
            OrderDO orderDO = BeanConvertUtils.copyProperties(orderInfoDTO, OrderDO.class);
            orderRepository.saveAndFlush(orderDO);
            OrderDetailDO detailDO = BeanConvertUtils.copyProperties(orderInfoDTO, OrderDetailDO.class);
            orderDetailRepository.saveAndFlush(detailDO);
        }catch (Exception e){
            throw new SpikeException("????????????????????????!");
        }
    }

    @Override
    public OrderInfoDTO getOrderInfoByOrderId(Long orderId) throws SpikeException {
        Optional<OrderDO> orderDO = orderRepository.findById(orderId);
        if(!orderDO.isPresent()){
            throw new SpikeException("?????????????????????!");
        }
        return BeanConvertUtils.copyProperties(orderDO,OrderInfoDTO.class);
    }

    @Override
    public void payOrder(Long skuId, Long orderId) throws SpikeException {
        try {
            orderRepository.updateStatusByOrderId(orderId);
        }catch(Exception e){
            throw new SpikeException("????????????????????????!");
        }
        //????????????
        amqpTemplate.convertAndSend("storage_queue",skuId);
    }
}
