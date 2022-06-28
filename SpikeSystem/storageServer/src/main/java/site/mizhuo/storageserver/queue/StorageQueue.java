package site.mizhuo.storageserver.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.mizhuo.storageserver.entity.DTO.StockStorageDTO;
import site.mizhuo.storageserver.exception.SpikeException;
import site.mizhuo.storageserver.service.IStorageService;

/**
 * @ClassName StorageQueue
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 10:34
 * @Version 1.0
 **/
@Slf4j
@Component
public class StorageQueue {

    @Autowired
    IStorageService storageService;

    /***
     * @Author MiZhuo
     * @Description 消费消息,修改库存
     * @Date 11:08 上午 2021/10/9
     * @Param [msg]
     * @return void
     **/
    @RabbitListener(queues = "storage_queue")
    public void getStorageQueue(Long msg) {
        log.info("storage_queue接收到消息,skuId:{}",msg);
        StockStorageDTO stockStorageDTO = new StockStorageDTO();
        try {
            stockStorageDTO.setSkuId(msg);
            stockStorageDTO.setInQuantity(0d);
            stockStorageDTO.setOutQuantity(-1d);
            storageService.insertStockStorage(stockStorageDTO);
        } catch (SpikeException e) {
            log.error("storage_queue处理消息失败:{}",e.getMessage());
        }
        log.info("storage_queue处理消息成功!");
    }
}
