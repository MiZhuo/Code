package site.mizhuo.storageserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.mizhuo.storageserver.entity.DTO.StockStorageDTO;
import site.mizhuo.storageserver.entity.VO.ResultVO;
import site.mizhuo.storageserver.entity.VO.StockStorageVO;
import site.mizhuo.storageserver.exception.SpikeException;
import site.mizhuo.storageserver.service.IStorageService;
import site.mizhuo.storageserver.utils.BeanConvertUtils;

/**
 * @ClassName StorageController
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 15:26
 * @Version 1.0
 **/
@RestController
public class StorageController {

    @Autowired
    IStorageService storageService;

    @GetMapping("/getStockStorage/{skuId}")
    public ResultVO getStockStorage(@PathVariable Long skuId){
        try {
            StockStorageDTO stockStorageDTO = storageService.getStockStorageById(skuId);
            return ResultVO.of(stockStorageDTO, true, "查询商品库存成功");
        }catch (SpikeException e){
            return ResultVO.of(null,false,e.getMessage());
        }
    }

    @PostMapping("/addStorage")
    public ResultVO addStorage(@RequestBody StockStorageVO storageVO){
        try {
            if(storageVO.getSkuId() == null){
                return ResultVO.of(null,false,"商品ID不能为空！");
            }
            if(storageVO.getInQuantity() == 0 && storageVO.getOutQuantity() == 0){
                return ResultVO.of(null,false,"入库数量和出库数量不能同时为0!");
            }
            StockStorageDTO stockStorageDTO = BeanConvertUtils.copyProperties(storageVO, StockStorageDTO.class);
            storageService.insertStockStorage(stockStorageDTO);
            return ResultVO.of(null,true,"添加商品库存成功!");
        }catch (SpikeException e){
            return ResultVO.of(null,false,e.getMessage());
        }
    }

}
