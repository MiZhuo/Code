package site.mizhuo.stockserver.entity.DO;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName SkuDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 18:09
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_sku", schema = "spike", catalog = "")
public class SkuDO {
    private Long id;
    private Long spuId;
    private String title;
    private String images;
    private Long stock;
    private Long price;
    private String indexes;
    private String ownSpec;
    private Boolean enable;
    private Timestamp createTime;
    private Timestamp updateTime;
    private SpuDetailDO spuDetailDO;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "spu_id")
    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "images")
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Basic
    @Column(name = "stock")
    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
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
    @Column(name = "indexes")
    public String getIndexes() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes = indexes;
    }

    @Basic
    @Column(name = "own_spec")
    public String getOwnSpec() {
        return ownSpec;
    }

    public void setOwnSpec(String ownSpec) {
        this.ownSpec = ownSpec;
    }

    @Basic
    @Column(name = "enable")
    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
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


    @OneToOne
    @JoinColumn(name = "spu_id",insertable = false,updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    public SpuDetailDO getSpuDetailDO() {
        return spuDetailDO;
    }

    public void setSpuDetailDO(SpuDetailDO spuDetailDO) {
        this.spuDetailDO = spuDetailDO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SkuDO skuDO = (SkuDO) o;
        return Objects.equals(id, skuDO.id) && Objects.equals(spuId, skuDO.spuId) && Objects.equals(title, skuDO.title) && Objects.equals(images, skuDO.images) && Objects.equals(stock, skuDO.stock) && Objects.equals(price, skuDO.price) && Objects.equals(indexes, skuDO.indexes) && Objects.equals(ownSpec, skuDO.ownSpec) && Objects.equals(enable, skuDO.enable) && Objects.equals(createTime, skuDO.createTime) && Objects.equals(updateTime, skuDO.updateTime) && Objects.equals(spuDetailDO, skuDO.spuDetailDO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spuId, title, images, stock, price, indexes, ownSpec, enable, createTime, updateTime, spuDetailDO);
    }

    @Override
    public String toString() {
        return "SkuDO{" +
                "id=" + id +
                ", spuId=" + spuId +
                ", title='" + title + '\'' +
                ", images='" + images + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", indexes='" + indexes + '\'' +
                ", ownSpec='" + ownSpec + '\'' +
                ", enable=" + enable +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", spuDetailDO=" + spuDetailDO +
                '}';
    }
}
