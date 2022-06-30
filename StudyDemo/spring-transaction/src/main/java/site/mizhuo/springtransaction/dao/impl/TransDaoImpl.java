package site.mizhuo.springtransaction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import site.mizhuo.springtransaction.dao.ITransDao;

/**
 * @ClassName TransDaoImpl
 * @Description:
 * @Author: MiZhuo
 * @Create: 2022-06-30 22:08
 * @Version 1.0
 **/
@Repository
public class TransDaoImpl implements ITransDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney(String id,Double amt){
        String sql = "update transdemo set amt = amt + ? where id = ?";
        jdbcTemplate.update(sql,amt,id);
    }

    @Override
    public void decrMoney(String id,Double amt){
        String sql = "update transdemo set amt = amt - ? where id = ?";
        jdbcTemplate.update(sql);
    }
}
