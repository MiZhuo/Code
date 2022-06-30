package site.mizhuo.springtransaction.dao;

/**
 * @InterfaceName ITransDao
 * @Description:
 * @Author: MiZhuo
 * @Create: 2022-06-30 22:08
 * @Version 1.0
 **/
public interface ITransDao {
    void addMoney(String id,Double amt);

    void decrMoney(String id,Double amt);
}
