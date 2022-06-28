package site.mizhuo.storageserver.entity.DTO;

/**
 * @ClassName StockStorageDTO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 15:31
 * @Version 1.0
 **/
public class StockStorageDTO {
    private Long id;
    private Long skuId;
    private Double quantity;
    private Double inQuantity;
    private Double outQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getInQuantity() {
        return inQuantity;
    }

    public void setInQuantity(Double inQuantity) {
        this.inQuantity = inQuantity;
    }

    public Double getOutQuantity() {
        return outQuantity;
    }

    public void setOutQuantity(Double outQuantity) {
        this.outQuantity = outQuantity;
    }
}
