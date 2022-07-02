package site.mizhuo.springtransaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import site.mizhuo.springtransaction.mapper.ITransMapper;
import site.mizhuo.springtransaction.service.ITransService;

/**
 * @ClassName TransService
 * @Description:
 * @Author: MiZhuo
 * @Create: 2022-06-30 22:04
 * @Version 1.0
 **/
@Service
public class TransServiceImpl implements ITransService {
    @Autowired
    private ITransMapper transMapper;

    /***
     * @Author MiZhuo
     * @Description 转账
     * @Date 12:55 上午 2022/7/2
     * @Param [from_id, to_id, amt]
     * @return void
     **/
    @Transactional(propagation= Propagation.REQUIRED)
    @Override
    public void trans(String from_id, String to_id, Double amt) {
        transMapper.decrMoney(from_id,amt);
        transMapper.addMoney(to_id,amt);
        this.deducFree(from_id,amt);
    }

    /***
     * @Author MiZhuo
     * @Description 扣除手续费
     * @Date 12:55 上午 2022/7/2
     * @Param [from_id, amt]
     * @return void
     **/
    @Transactional(propagation= Propagation.REQUIRED)
    @Override
    public void deducFree(String from_id, Double amt) {
        Double free = amt * 0.001;
        transMapper.decrMoney(from_id,free);
        int i = 1/0;
        transMapper.addMoney("3",free);
    }
}
