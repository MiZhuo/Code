package site.mizhuo.stockserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.mizhuo.stockserver.entity.DTO.LimitPolicyDTO;
import site.mizhuo.stockserver.entity.DTO.SkuDTO;
import site.mizhuo.stockserver.entity.DTO.SkuDetailDTO;
import site.mizhuo.stockserver.entity.VO.LimitPolicyVO;
import site.mizhuo.stockserver.entity.VO.ResultVO;
import site.mizhuo.stockserver.exception.SpikeException;
import site.mizhuo.stockserver.service.IStockService;
import site.mizhuo.stockserver.utils.BeanConvertUtils;

import java.util.List;

/**
 * @ClassName StockController
 * @Description: 商品Controller
 * @Author: MiZhuo
 * @Create: 2021-10-06 10:56
 * @Version 1.0
 **/
@RestController
public class StockController {
    @Autowired
    IStockService stockService;

    @GetMapping("/getStock")
    public ResultVO<List<SkuDTO>> getStockList(){
        try {
            List<SkuDTO> stockList = stockService.getStockList();
            return ResultVO.of(stockList,true,"查询商品列表成功!");
        }catch (SpikeException e){
            return ResultVO.of(null,false,e.getMessage());
        }
    }

    @GetMapping("/getStockDetail/{id}")
    public ResultVO getStockDetailById(@PathVariable Long id){
        try {
            SkuDetailDTO skuDetail = stockService.getStockDetailById(id);
            if (skuDetail == null) {
                return ResultVO.of(null, true, "查询无此商品");
            }
            return ResultVO.of(skuDetail, true, "查询商品详情成功!");
        }catch (SpikeException e){
            return ResultVO.of(null,false,e.getMessage());
        }
    }

    @PostMapping("/addLimitPolicy")
    public ResultVO addLimitPolicy(@RequestBody LimitPolicyVO vo){
        LimitPolicyDTO limitPolicyDTO = BeanConvertUtils.copyProperties(vo, LimitPolicyDTO.class);
        try {
            stockService.addLimitPolicy(limitPolicyDTO);
        } catch (SpikeException e) {
            return ResultVO.of(null,false,e.getMessage());
        }
        return ResultVO.of(null,true,"保存秒杀策略成功!");
    }
}
