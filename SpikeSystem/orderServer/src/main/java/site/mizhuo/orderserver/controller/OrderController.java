package site.mizhuo.orderserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import site.mizhuo.orderserver.entity.DTO.OrderDTO;
import site.mizhuo.orderserver.entity.DTO.OrderInfoDTO;
import site.mizhuo.orderserver.entity.DTO.UserDTO;
import site.mizhuo.orderserver.entity.VO.ResultVO;
import site.mizhuo.orderserver.exception.SpikeException;
import site.mizhuo.orderserver.service.IOrderService;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName OrderController
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 13:17
 * @Version 1.0
 **/
@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping("/createOrder/{skuId}")
    public ResultVO createOrder(@PathVariable Long skuId, HttpServletRequest request){
        if (skuId == null) {
            return ResultVO.of(null, false, "商品ID不能为空!");
        }
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        if (userDTO == null) {
            return ResultVO.of(null, false, "用户信息已失效!");
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setSkuId(skuId);
        orderDTO.setUserId(userDTO.getId());
        try {
            orderDTO = orderService.createOrderInfo(orderDTO);
        } catch (SpikeException e) {
            return ResultVO.of(null,false,e.getMessage());
        }
        return ResultVO.of(orderDTO,true,"创建订单成功!");
    }


    @GetMapping("/getOrder/{orderId}")
    public ResultVO getOrderInfo(@PathVariable Long orderId){
        if (orderId == null) {
            return ResultVO.of(null, false, "订单ID不能为空!");
        }
        try {
            OrderInfoDTO orderInfoDTO = orderService.getOrderInfoByOrderId(orderId);
            return ResultVO.of(orderInfoDTO,true,"查询订单信息成功!");
        } catch (SpikeException e) {
            return ResultVO.of(null,false,e.getMessage());
        }
    }

    @GetMapping("/payOrder/{skuId}/{orderId}")
    public ResultVO payOrder(@PathVariable Long skuId,@PathVariable Long orderId){
        if(skuId == null || orderId == null){
            return ResultVO.of(null,false,"支付信息有误!");
        }
        try {
            //调用支付接口,此处模拟正常支付成功
            Boolean isPay = true;
            if(!isPay){
                return ResultVO.of(null,false,"支付失败!");
            }
            orderService.payOrder(skuId,orderId);
            return ResultVO.of(null,true,"支付成功!");
        }catch (SpikeException e){
            return ResultVO.of(null,false,e.getMessage());
        }
    }
}
