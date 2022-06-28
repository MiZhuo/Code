package site.mizhuo.stockserver.entity.DO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName SpuDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_spu", schema = "spike", catalog = "")
public class SpuDO {
    private Long id;
    private String name;
    private String subTitle;
    private Long cid1;
    private Long cid2;
    private Long cid3;
    private Long brandId;
    private Boolean saleable;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sub_title")
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Basic
    @Column(name = "cid1")
    public Long getCid1() {
        return cid1;
    }

    public void setCid1(Long cid1) {
        this.cid1 = cid1;
    }

    @Basic
    @Column(name = "cid2")
    public Long getCid2() {
        return cid2;
    }

    public void setCid2(Long cid2) {
        this.cid2 = cid2;
    }

    @Basic
    @Column(name = "cid3")
    public Long getCid3() {
        return cid3;
    }

    public void setCid3(Long cid3) {
        this.cid3 = cid3;
    }

    @Basic
    @Column(name = "brand_id")
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "saleable")
    public Boolean getSaleable() {
        return saleable;
    }

    public void setSaleable(Boolean saleable) {
        this.saleable = saleable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpuDO spuDO = (SpuDO) o;
        return Objects.equals(id, spuDO.id) && Objects.equals(name, spuDO.name) && Objects.equals(subTitle, spuDO.subTitle) && Objects.equals(cid1, spuDO.cid1) && Objects.equals(cid2, spuDO.cid2) && Objects.equals(cid3, spuDO.cid3) && Objects.equals(brandId, spuDO.brandId) && Objects.equals(saleable, spuDO.saleable) && Objects.equals(createTime, spuDO.createTime) && Objects.equals(updateTime, spuDO.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subTitle, cid1, cid2, cid3, brandId, saleable, createTime, updateTime);
    }

    @Override
    public String toString() {
        return "SpuDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", cid1=" + cid1 +
                ", cid2=" + cid2 +
                ", cid3=" + cid3 +
                ", brandId=" + brandId +
                ", saleable=" + saleable +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
