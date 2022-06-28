package site.mizhuo.orderserver.entity.DTO;

/**
 * @ClassName OrderDTO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 13:18
 * @Version 1.0
 **/
public class OrderDTO {
    private Long orderId;
    private Long skuId;
    private Long userId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
