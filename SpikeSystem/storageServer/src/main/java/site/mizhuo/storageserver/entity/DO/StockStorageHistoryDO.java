package site.mizhuo.storageserver.entity.DO;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName StockStorageHistoryDO
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 15:20
 * @Version 1.0
 **/
@Entity
@Table(name = "tb_stock_storage_history", schema = "spike", catalog = "")
public class StockStorageHistoryDO {
    private Long id;
    private Long stockStorageId;
    private Double inQuantity;
    private Double outQuantity;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stock_storage_id")
    public Long getStockStorageId() {
        return stockStorageId;
    }

    public void setStockStorageId(Long stockStorageId) {
        this.stockStorageId = stockStorageId;
    }

    @Basic
    @Column(name = "in_quanty")
    public Double getInQuantity() {
        return inQuantity;
    }

    public void setInQuantity(Double inQuantity) {
        this.inQuantity = inQuantity;
    }

    @Basic
    @Column(name = "out_quanty")
    public Double getOutQuantity() {
        return outQuantity;
    }

    public void setOutQuantity(Double outQuantity) {
        this.outQuantity = outQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StockStorageHistoryDO that = (StockStorageHistoryDO) o;
        return Objects.equals(id, that.id) && Objects.equals(stockStorageId, that.stockStorageId) && Objects.equals(inQuantity, that.inQuantity) && Objects.equals(outQuantity, that.outQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stockStorageId, inQuantity, outQuantity);
    }
}
