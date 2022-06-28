package site.mizhuo.stockserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.mizhuo.stockserver.entity.DO.SkuDO;

/**
 * @InterfaceName StockRepository
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 11:00
 * @Version 1.0
 **/
public interface IStockRepository extends JpaRepository<SkuDO,Long>{
}
