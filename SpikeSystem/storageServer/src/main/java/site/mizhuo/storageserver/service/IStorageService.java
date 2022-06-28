package site.mizhuo.storageserver.service;

import site.mizhuo.storageserver.entity.DTO.StockStorageDTO;
import site.mizhuo.storageserver.exception.SpikeException;

/**
 * @InterfaceName IStorageService
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 15:29
 * @Version 1.0
 **/
public interface IStorageService {
    /***
     * @Author MiZhuo
     * @Description 查询商品库存
     * @Date 3:32 下午 2021/10/8
     * @Param [skuId]
     * @return site.mizhuo.storageserver.entity.DTO.StockStorageDTO
     **/
    StockStorageDTO getStockStorageById(Long skuId) throws SpikeException;

    /*** 
     * @Author MiZhuo
     * @Description 修改库存
     * @Date 3:50 下午 2021/10/8
     * @Param [stockStorageDTO]
     * @return void
     **/
    void insertStockStorage(StockStorageDTO stockStorageDTO) throws SpikeException;
}
