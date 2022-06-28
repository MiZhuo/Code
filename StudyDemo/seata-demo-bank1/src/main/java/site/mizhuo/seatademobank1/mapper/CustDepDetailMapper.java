package site.mizhuo.seatademobank1.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author: Mizhuo
 * @time: 2021/3/29 10:32 下午
 * @description:
 */
public interface CustDepDetailMapper {
    @Update("UPDATE CUST_DEP_DETAIL SET DEP_BAL = DEP_BAL + #{amount} WHERE ID = #{id}")
    void updateCustDepBal(@Param("id") Integer id, @Param("amount") double amount);
}
