package site.mizhuo.stockserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.mizhuo.stockserver.entity.DO.LimitPolicyDO;
import site.mizhuo.stockserver.entity.VO.LimitPolicyVO;

/**
 * @InterfaceName LimitPolicyRepository
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 10:04
 * @Version 1.0
 **/
public interface ILimitPolicyRepository extends JpaRepository<LimitPolicyDO,Long> {
}
