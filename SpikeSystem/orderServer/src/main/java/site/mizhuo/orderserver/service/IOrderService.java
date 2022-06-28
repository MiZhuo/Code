package site.mizhuo.orderserver.service;

import site.mizhuo.orderserver.entity.DTO.OrderDTO;
import site.mizhuo.orderserver.entity.DTO.OrderInfoDTO;
import site.mizhuo.orderserver.exception.SpikeException;

/**
 * @InterfaceName IOrderService
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 13:18
 * @Version 1.0
 **/
public interface IOrderService {

    /***
     * @Author MiZhuo
     * @Description 创建订单
     * @Date 4:31 下午 2021/10/10
     * @Param
     * @return
     **/
    OrderDTO createOrderInfo(OrderDTO orderDTO) throws SpikeException;

    /***
     * @Author MiZhuo
     * @Description
     * @Date 4:32 下午 2021/10/10
     * @Param [orderInfoDTO]
     * @return void
     **/
    void  addOrder(OrderInfoDTO orderInfoDTO) throws SpikeException;

    /***
     * @Author MiZhuo
     * @Description 根据订单编号获取订单内容
     * @Date 4:51 下午 2021/10/10
     * @Param [orderId]
     * @return site.mizhuo.orderserver.entity.DTO.OrderInfoDTO
     **/
    OrderInfoDTO getOrderInfoByOrderId(Long orderId) throws SpikeException;

    /***
     * @Author MiZhuo
     * @Description 支付订单
     * @Date 5:08 下午 2021/10/10
     * @Param [skuId, orderId]
     * @return void
     **/
    void payOrder(Long skuId, Long orderId) throws SpikeException;
}
