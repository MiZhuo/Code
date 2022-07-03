package site.mizhuo.springtransaction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @InterfaceName: IFreeMapper
 * @Author: MiZhuo
 * @Date: 2022/7/3 14:32
 * @Description: 定义一个扣减金额和一个增加金额的方法
 */
@Mapper
public interface IFreeMapper {
    @Update("insert into free_info values(#{id},#{amt},CURRENT_TIME)")
    void addFreeInfo(String id,Double amt);
}
