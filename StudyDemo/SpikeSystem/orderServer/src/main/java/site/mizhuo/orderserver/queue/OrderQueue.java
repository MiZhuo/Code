package site.mizhuo.orderserver.queue;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.mizhuo.orderserver.entity.DTO.OrderInfoDTO;
import site.mizhuo.orderserver.exception.SpikeException;
import site.mizhuo.orderserver.service.IOrderService;

/**
 * @ClassName OrderQueue
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-10 16:38
 * @Version 1.0
 **/
@Slf4j
@Component
public class OrderQueue {

    @Autowired
    IOrderService orderService;

    @RabbitListener(queues = "order_queue")
    public void addOrder(String msg){
        OrderInfoDTO orderInfoDTO = JSONObject.parseObject(msg, OrderInfoDTO.class);
        try {
            orderService.addOrder(orderInfoDTO);
        } catch (SpikeException e) {
            log.error("order_queue:处理消息失败,失败原因:{}",e.getMessage());
        }
        log.info("order_queue:处理消息成功!");
    }
}
