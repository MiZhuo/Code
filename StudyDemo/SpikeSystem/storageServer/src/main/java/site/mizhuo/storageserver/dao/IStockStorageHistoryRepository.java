package site.mizhuo.storageserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.mizhuo.storageserver.entity.DO.StockStorageHistoryDO;

/**
 * @InterfaceName IStockStorageHistoryRepository
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 20:38
 * @Version 1.0
 **/
public interface IStockStorageHistoryRepository extends JpaRepository<StockStorageHistoryDO,Long> {
}
