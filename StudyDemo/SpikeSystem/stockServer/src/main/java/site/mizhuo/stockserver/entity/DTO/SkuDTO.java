package site.mizhuo.stockserver.entity.DTO;

import java.sql.Timestamp;

/**
 * @ClassName SkuDTO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:38
 * @Version 1.0
 **/
public class SkuDTO {
    private Long id;
    private String title;
    private String images;
    private Integer stock;
    private Long price;
    private String indexes;
    private String ownSpec;
    private Boolean enable;

    private LimitPolicyDTO limitPolicyDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getIndexes() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes = indexes;
    }

    public String getOwnSpec() {
        return ownSpec;
    }

    public void setOwnSpec(String ownSpec) {
        this.ownSpec = ownSpec;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public LimitPolicyDTO getLimitPolicyDTO() {
        return limitPolicyDTO;
    }

    public void setLimitPolicyDTO(LimitPolicyDTO limitPolicyDTO) {
        this.limitPolicyDTO = limitPolicyDTO;
    }
}
