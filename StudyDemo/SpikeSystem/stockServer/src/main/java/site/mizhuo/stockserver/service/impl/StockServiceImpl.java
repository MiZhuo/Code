package site.mizhuo.stockserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import site.mizhuo.stockserver.api.TimeFeignClient;
import site.mizhuo.stockserver.dao.ILimitPolicyRepository;
import site.mizhuo.stockserver.dao.IStockRepository;
import site.mizhuo.stockserver.entity.DO.LimitPolicyDO;
import site.mizhuo.stockserver.entity.DO.SkuDO;
import site.mizhuo.stockserver.entity.DTO.LimitPolicyDTO;
import site.mizhuo.stockserver.entity.DTO.SkuDTO;
import site.mizhuo.stockserver.entity.DTO.SkuDetailDTO;
import site.mizhuo.stockserver.exception.SpikeException;
import site.mizhuo.stockserver.service.IStockService;
import site.mizhuo.stockserver.utils.BeanConvertUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName StockServiceImpl
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 10:57
 * @Version 1.0
 **/
@Slf4j
@Service
public class StockServiceImpl implements IStockService {

    @Autowired
    IStockRepository stockRepository;

    @Autowired
    ILimitPolicyRepository limitPolicyRepository;

    @Autowired
    TimeFeignClient feignClient;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List<SkuDTO> getStockList() throws SpikeException {
        List<SkuDO> skuDOList = stockRepository.findAll();
        List<SkuDTO> skuDTOList = new ArrayList<>();
        for (SkuDO skuDO : skuDOList) {
            SkuDTO skuDTO = BeanConvertUtils.copyProperties(skuDO, SkuDTO.class);
            LimitPolicyDTO limitPolicy = getLimitPolicy(skuDO);
            skuDTO.setLimitPolicyDTO(limitPolicy);
            skuDTOList.add(skuDTO);
        }
        return skuDTOList;
    }

    @Override
    public SkuDetailDTO getStockDetailById(Long id) throws SpikeException {
        Optional<SkuDO> skuDO = stockRepository.findById(id);
        if(!skuDO.isPresent()){
            log.error("无此商品信息,id:{}",id);
            return null;
        }
        SkuDetailDTO skuDetailDTO = BeanConvertUtils.copyProperties(skuDO.get(), SkuDetailDTO.class);
        LimitPolicyDTO limitPolicy = getLimitPolicy(skuDO.get());
        skuDetailDTO.setLimitPolicyDTO(limitPolicy);
        return skuDetailDTO;
    }

    @Override
    public void addLimitPolicy(LimitPolicyDTO limitPolicyDTO) throws SpikeException {
        try {
            LimitPolicyDO limitPolicyDO = BeanConvertUtils.copyProperties(limitPolicyDTO, LimitPolicyDO.class);
            limitPolicyDO = limitPolicyRepository.saveAndFlush(limitPolicyDO);
            if(limitPolicyDO == null){
                throw new SpikeException("保存信息失败!");
            }
            limitPolicyDTO = BeanConvertUtils.copyProperties(limitPolicyDO,LimitPolicyDTO.class);
            long diff = 0;
            String now = feignClient.getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date endTime = limitPolicyDO.getEndTime();
            Date nowTime = dateFormat.parse(now);
            diff = (endTime.getTime() - nowTime.getTime()) / 1000;
            if(diff <= 0){
                throw new SpikeException("结束时间不能小于当前时间!");
            }
            redisTemplate.opsForValue().set("LIMIT_POLICY_" + limitPolicyDO.getSkuId(), JSON.toJSONString(limitPolicyDO),diff, TimeUnit.SECONDS);
            redisTemplate.opsForValue().set("SKU_" + limitPolicyDO.getSkuId(),JSON.toJSONString(getStockDetailById(limitPolicyDO.getSkuId())),diff, TimeUnit.SECONDS);
        } catch (ParseException e) {
            throw new SpikeException("时间转换异常!");
        }
    }

    /***
     * @Author MiZhuo
     * @Description 从redis获取秒杀政策
     * @Date 11:39 上午 2021/10/8
     * @Param [skuDO]
     * @return void
     **/
    private LimitPolicyDTO getLimitPolicy(SkuDO skuDO) throws SpikeException {
        try {
            Object limitPolicy = redisTemplate.opsForValue().get("LIMIT_POLICY_" + skuDO.getId());
            if(limitPolicy != null) {
                LimitPolicyDO limitPolicyDO = JSONObject.parseObject(limitPolicy.toString(), LimitPolicyDO.class);
                if (limitPolicyDO != null) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String now = feignClient.getTime();
                    Date beginTime = limitPolicyDO.getBeginTime();
                    Date endTime = limitPolicyDO.getEndTime();
                    Date nowTime = dateFormat.parse(now);
                    if (beginTime.getTime() <= nowTime.getTime() && nowTime.getTime() <= endTime.getTime()) {
                        return BeanConvertUtils.copyProperties(limitPolicyDO, LimitPolicyDTO.class);
                    }
                }
            }
            return null;
        } catch (ParseException e) {
            throw new SpikeException("时间转换异常!");
        }
    }
}
