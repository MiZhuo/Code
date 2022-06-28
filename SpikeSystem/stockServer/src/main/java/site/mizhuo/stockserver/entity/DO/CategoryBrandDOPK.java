package site.mizhuo.stockserver.entity.DO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName CategoryBrandDOPK
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
public class CategoryBrandDOPK implements Serializable {
    private Long categoryId;
    private Long brandId;

    @Column(name = "category_id")
    @Id
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "brand_id")
    @Id
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
        CategoryBrandDOPK that = (CategoryBrandDOPK) o;
        return Objects.equals(categoryId, that.categoryId) && Objects.equals(brandId, that.brandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, brandId);
    }
}
