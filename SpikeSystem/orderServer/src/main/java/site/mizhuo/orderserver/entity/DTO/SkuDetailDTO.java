package site.mizhuo.orderserver.entity.DTO;

import java.sql.Timestamp;

/**
 * @ClassName SkuDetailDTO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-07 10:15
 * @Version 1.0
 **/
public class SkuDetailDTO {
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
    private SpuDetailDTO spuDetailDTO;
    private LimitPolicyDTO limitPolicyDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
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

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public SpuDetailDTO getSpuDetailDTO() {
        return spuDetailDTO;
    }

    public void setSpuDetailDTO(SpuDetailDTO spuDetailDTO) {
        this.spuDetailDTO = spuDetailDTO;
    }

    public LimitPolicyDTO getLimitPolicyDTO() {
        return limitPolicyDTO;
    }

    public void setLimitPolicyDTO(LimitPolicyDTO limitPolicyDTO) {
        this.limitPolicyDTO = limitPolicyDTO;
    }
}
