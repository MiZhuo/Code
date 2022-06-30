package site.mizhuo.springtransaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.mizhuo.springtransaction.dao.ITransDao;
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
    private ITransDao transDao;

    @Transactional
    @Override
    public void trans(String from_id, String to_id, Double amt) {
        transDao.decrMoney(from_id,amt);
        transDao.addMoney(to_id,amt);
    }
}
