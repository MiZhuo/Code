package site.mizhuo.orderserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import site.mizhuo.orderserver.entity.DO.OrderDO;

/**
 * @InterfaceName IOrderRepository
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-09 13:16
 * @Version 1.0
 **/
public interface IOrderRepository extends JpaRepository<OrderDO,Long> {

    /***
     * @Author MiZhuo
     * @Description 更加订单ID更新订单状态
     * @Date 5:09 下午 2021/10/10
     * @Param [orderId]
     * @return void
     **/
    @Modifying
    @Query(value = "update OrderDO o set o.status = 1 where o.orderId = ?1",nativeQuery = true)
    void updateStatusByOrderId(Long orderId);
}
