package site.mizhuo.stockserver.service;

import site.mizhuo.stockserver.entity.DTO.LimitPolicyDTO;
import site.mizhuo.stockserver.entity.DTO.SkuDTO;
import site.mizhuo.stockserver.entity.DTO.SkuDetailDTO;
import site.mizhuo.stockserver.entity.VO.LimitPolicyVO;
import site.mizhuo.stockserver.exception.SpikeException;

import java.util.List;

/**
 * @ClassName StockService
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 10:57
 * @Version 1.0
 **/
public interface IStockService {

    /***
     * @Author MiZhuo
     * @Description 获取商品列表
     * @Date 3:38 下午 2021/10/6
     * @Param []
     * @return java.util.List<site.mizhuo.stockserver.entity.DTO.SkuDTO>
     **/
    List<SkuDTO> getStockList() throws SpikeException;

    /***
     * @Author MiZhuo
     * @Description 获取商品详情
     * @Date 10:16 上午 2021/10/7
     * @Param [id]
     * @return site.mizhuo.stockserver.entity.DTO.SkuDetailDTO
     **/
    SkuDetailDTO getStockDetailById(Long id) throws SpikeException;

    /***
     * @Author MiZhuo
     * @Description 保存秒杀策略
     * @Date 11:22 上午 2021/10/8
     * @Param [limitPolicyDTO]
     * @return void
     **/
    void addLimitPolicy(LimitPolicyDTO limitPolicyDTO) throws SpikeException;
}
