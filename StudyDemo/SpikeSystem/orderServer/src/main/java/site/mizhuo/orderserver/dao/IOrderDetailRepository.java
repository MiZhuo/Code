package site.mizhuo.orderserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.mizhuo.orderserver.entity.DO.OrderDO;
import site.mizhuo.orderserver.entity.DO.OrderDetailDO;

/**
 * @InterfaceName IOrderDetailRepository
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-10 16:16
 * @Version 1.0
 **/
public interface IOrderDetailRepository extends JpaRepository<OrderDetailDO,Long> {
}
