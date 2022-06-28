package site.mizhuo.stockserver.entity.DO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName ShoppingcartDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_shoppingcart", schema = "spike", catalog = "")
public class ShoppingcartDO {
    private Long id;
    private Long skuId;
    private BigDecimal quanty;
    private BigDecimal price;
    private BigDecimal amount;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer canceled;

    @Id
    @Column(name = "id")
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
    public BigDecimal getQuanty() {
        return quanty;
    }

    public void setQuanty(BigDecimal quanty) {
        this.quanty = quanty;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "canceled")
    public Integer getCanceled() {
        return canceled;
    }

    public void setCanceled(Integer canceled) {
        this.canceled = canceled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShoppingcartDO that = (ShoppingcartDO) o;
        return Objects.equals(id, that.id) && Objects.equals(skuId, that.skuId) && Objects.equals(quanty, that.quanty) && Objects.equals(price, that.price) && Objects.equals(amount, that.amount) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(canceled, that.canceled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skuId, quanty, price, amount, createTime, updateTime, canceled);
    }
}
