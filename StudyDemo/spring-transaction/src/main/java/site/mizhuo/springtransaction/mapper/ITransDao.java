package site.mizhuo.springtransaction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @InterfaceName ITransDao
 * @Description:
 * @Author: MiZhuo
 * @Create: 2022-06-30 22:08
 * @Version 1.0
 **/
@Mapper
public interface ITransDao {
    @Update("update transdemo set amt = amt + #{amt} where id = #{id}")
    void addMoney(String id,Double amt);

    @Update("update transdemo set amt = amt - #{amt} where id = #{id}")
    void decrMoney(String id,Double amt);
}
