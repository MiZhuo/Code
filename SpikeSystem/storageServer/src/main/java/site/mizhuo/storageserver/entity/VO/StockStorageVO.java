package site.mizhuo.storageserver.entity.VO;

/**
 * @ClassName StockStorageVO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 15:47
 * @Version 1.0
 **/
public class StockStorageVO {
    private Long skuId;
    private Double inQuantity;
    private Double outQuantity;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
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
