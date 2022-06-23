package site.mizhuo.orderserver.entity.DO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName LimitPolicyDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_limit_policy", schema = "spike", catalog = "")
public class LimitPolicyDO {
    private Long id;
    private Long skuId;
    private Long quantity;
    private Long price;
    private Timestamp beginTime;
    private Timestamp endTime;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sku_id")
    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    @Basic
    @Column(name = "quanty")
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "begin_time")
    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LimitPolicyDO that = (LimitPolicyDO) o;
        return Objects.equals(id, that.id) && Objects.equals(skuId, that.skuId) && Objects.equals(quantity, that.quantity) && Objects.equals(price, that.price) && Objects.equals(beginTime, that.beginTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skuId, quantity, price, beginTime, endTime);
    }
}
