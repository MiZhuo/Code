package site.mizhuo.stockserver.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * @ClassName LimitPolicyVO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-07 12:14
 * @Version 1.0
 **/
public class LimitPolicyVO {
    private Long skuId;
    private Long quanty;
    private Long price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
    private Timestamp beginTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
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

    @Override
    public String toString() {
        return "LimitPolicyVO{" +
                "skuId=" + skuId +
                ", quanty=" + quanty +
                ", price=" + price +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}
