package site.mizhuo.storageserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import site.mizhuo.storageserver.entity.DO.StockStorageDO;

import java.util.Optional;

/**
 * @InterfaceName IStockStorageRepository
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 15:33
 * @Version 1.0
 **/
public interface IStockStorageRepository extends JpaRepository<StockStorageDO,Long> {
    Optional<StockStorageDO> findBySkuId(Long skuId);
}
