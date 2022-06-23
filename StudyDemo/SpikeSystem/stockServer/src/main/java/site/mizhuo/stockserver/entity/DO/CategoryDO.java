package site.mizhuo.stockserver.entity.DO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName CategoryDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_category", schema = "spike", catalog = "")
public class CategoryDO {
    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private Boolean sort;
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
    @Column(name = "parent_id")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "is_parent")
    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    @Basic
    @Column(name = "sort")
    public Boolean getSort() {
        return sort;
    }

    public void setSort(Boolean sort) {
        this.sort = sort;
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
        CategoryDO that = (CategoryDO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(parentId, that.parentId) && Objects.equals(isParent, that.isParent) && Objects.equals(sort, that.sort) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, parentId, isParent, sort, createTime, updateTime);
    }
}
