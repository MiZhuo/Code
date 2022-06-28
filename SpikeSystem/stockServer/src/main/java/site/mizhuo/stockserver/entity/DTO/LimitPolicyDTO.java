package site.mizhuo.stockserver.entity.DTO;

import java.sql.Timestamp;

/**
 * @ClassName LimitPolicyDTO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 10:16
 * @Version 1.0
 **/
public class LimitPolicyDTO {
    private Long skuId;
    private Long quanty;
    private Long price;
    private Timestamp beginTime;
    private Timestamp endTime;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getQuanty() {
        return quanty;
    }

    public void setQuanty(Long quanty) {
        this.quanty = quanty;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

}
