package site.mizhuo.springtransaction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @InterfaceName ITransMapper
 * @Description: 定义一个扣减金额和一个增加金额的方法
 * @Author: MiZhuo
 * @Create: 2022-06-30 22:08
 * @Version 1.0
 **/
@Mapper
public interface ITransMapper {
    @Update("update transdemo set amt = amt + #{amt} where id = #{id}")
    void addMoney(String id,Double amt);

    @Update("update transdemo set amt = amt - #{amt} where id = #{id}")
    void decrMoney(String id,Double amt);

}
