package site.mizhuo.storageserver.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.mizhuo.storageserver.dao.IStockStorageHistoryRepository;
import site.mizhuo.storageserver.dao.IStockStorageRepository;
import site.mizhuo.storageserver.entity.DO.StockStorageDO;
import site.mizhuo.storageserver.entity.DO.StockStorageHistoryDO;
import site.mizhuo.storageserver.entity.DTO.StockStorageDTO;
import site.mizhuo.storageserver.exception.SpikeException;
import site.mizhuo.storageserver.service.IStorageService;
import site.mizhuo.storageserver.utils.BeanConvertUtils;

import java.util.Optional;

/**
 * @ClassName StorageServiceImpl
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 15:29
 * @Version 1.0
 **/
@Slf4j
@Service
public class StorageServiceImpl implements IStorageService {

    @Autowired
    IStockStorageRepository stockStorageRepository;

    @Autowired
    IStockStorageHistoryRepository stockStorageHistoryRepository;

    @Override
    public StockStorageDTO getStockStorageById(Long skuId) throws SpikeException {
        Optional<StockStorageDO> stockStorageDO = stockStorageRepository.findBySkuId(skuId);
        if(!stockStorageDO.isPresent()){
            log.error("无该商品库存信息!skuId:{}",skuId);
            throw new SpikeException("无该商品库存信息!");
        }
        return BeanConvertUtils.copyProperties(stockStorageDO.get(), StockStorageDTO.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertStockStorage(StockStorageDTO stockStorageDTO) throws SpikeException {
        //1:查询该商品是否有库存信息
        Optional<StockStorageDO> optionalStockStorageDO = stockStorageRepository.findBySkuId(stockStorageDTO.getSkuId());
        Long storageId = null ;
        Double thisQuantity = stockStorageDTO.getInQuantity()  - stockStorageDTO.getOutQuantity();
        //2:如果没有库存信息,则新增主表库存并获取库存ID
        if(optionalStockStorageDO.isPresent()){
            storageId = optionalStockStorageDO.get().getId();
        }else{
            StockStorageDO stockStorageDO = BeanConvertUtils.copyProperties(stockStorageDTO,StockStorageDO.class);
            stockStorageDO.setQuantity(thisQuantity);
            if(thisQuantity <= 0 ){
                log.error("更新主表失败,库存不足!");
                throw new SpikeException("更新主表失败,库存不足!");
            }
            stockStorageDO = stockStorageRepository.saveAndFlush(stockStorageDO);
            storageId = stockStorageDO.getId();
        }
        //3:将库存信息写入历史表
        StockStorageHistoryDO historyDO = new StockStorageHistoryDO();
        historyDO.setStockStorageId(storageId);
        historyDO.setInQuantity(stockStorageDTO.getInQuantity());
        historyDO.setOutQuantity(stockStorageDTO.getOutQuantity());
        historyDO = stockStorageHistoryRepository.saveAndFlush(historyDO);
        if(historyDO == null || historyDO.getId() == null){
            log.error("写入历史表失败!");
            throw new SpikeException("写入历史表失败!");
        }
        //4:更新库存主表
        if(optionalStockStorageDO.isPresent()){
            StockStorageDO stockStorageDO = BeanConvertUtils.copyProperties(optionalStockStorageDO.get(),StockStorageDO.class);
            if(stockStorageDO.getQuantity() + thisQuantity < 0 ){
                log.error("更新主表失败,库存不足!");
                throw new SpikeException("更新主表失败,库存不足!");
            }
            stockStorageDO.setQuantity(stockStorageDO.getQuantity() + thisQuantity);
            stockStorageRepository.saveAndFlush(stockStorageDO);
        }
    }
}
