package site.mizhuo.seatademobank2.mapper;

import org.apache.ibatis.annotations.Update;

/**
 * @author: Mizhuo
 * @time: 2021/3/31 10:44 下午
 * @description:
 */
public interface CustDepDetailMapper {

    @Update("UPDATE CUST_DEP_DETAIL SET DEP_BAL = DEP_BAL + #{amount} WHERE ID = #{id}")
    void updateCustDepBal(int id, double amount);
}
