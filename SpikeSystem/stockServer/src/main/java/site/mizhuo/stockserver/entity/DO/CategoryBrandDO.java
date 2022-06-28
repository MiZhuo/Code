package site.mizhuo.stockserver.entity.DO;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName CategoryBrandDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_category_brand", schema = "spike", catalog = "")
@IdClass(CategoryBrandDOPK.class)
public class CategoryBrandDO {
    private Long categoryId;
    private Long brandId;

    @Id
    @Column(name = "category_id")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Id
    @Column(name = "brand_id")
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategoryBrandDO that = (CategoryBrandDO) o;
        return Objects.equals(categoryId, that.categoryId) && Objects.equals(brandId, that.brandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, brandId);
    }
}
