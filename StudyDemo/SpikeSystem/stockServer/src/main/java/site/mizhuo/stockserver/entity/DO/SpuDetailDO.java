package site.mizhuo.stockserver.entity.DO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName SpuDetailDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_spu_detail", schema = "spike", catalog = "")
public class SpuDetailDO {
    private Long spuId;
    private String description;
    private String genericSpec;
    private String specialSpec;
    private String packingList;
    private String afterService;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "spu_id")
    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "generic_spec")
    public String getGenericSpec() {
        return genericSpec;
    }

    public void setGenericSpec(String genericSpec) {
        this.genericSpec = genericSpec;
    }

    @Basic
    @Column(name = "special_spec")
    public String getSpecialSpec() {
        return specialSpec;
    }

    public void setSpecialSpec(String specialSpec) {
        this.specialSpec = specialSpec;
    }

    @Basic
    @Column(name = "packing_list")
    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    @Basic
    @Column(name = "after_service")
    public String getAfterService() {
        return afterService;
    }

    public void setAfterService(String afterService) {
        this.afterService = afterService;
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
        SpuDetailDO that = (SpuDetailDO) o;
        return Objects.equals(spuId, that.spuId) && Objects.equals(description, that.description) && Objects.equals(genericSpec, that.genericSpec) && Objects.equals(specialSpec, that.specialSpec) && Objects.equals(packingList, that.packingList) && Objects.equals(afterService, that.afterService) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spuId, description, genericSpec, specialSpec, packingList, afterService, createTime, updateTime);
    }

    @Override
    public String toString() {
        return "SpuDetailDO{" +
                "spuId=" + spuId +
                ", description='" + description + '\'' +
                ", genericSpec='" + genericSpec + '\'' +
                ", specialSpec='" + specialSpec + '\'' +
                ", packingList='" + packingList + '\'' +
                ", afterService='" + afterService + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
