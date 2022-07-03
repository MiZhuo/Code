package site.mizhuo.springtransaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import site.mizhuo.springtransaction.mapper.IFreeMapper;
import site.mizhuo.springtransaction.service.IFreeService;

/**
 * @ClassName: FreeServiceImpl
 * @Author: MiZhuo
 * @Date: 2022/7/3 13:31
 * @Description: 手续费服务
 */
@Service
public class FreeServiceImpl implements IFreeService {

    @Autowired
    private IFreeMapper freeMapper;
    /***
     * @Author MiZhuo
     * @Description 新增手续费记录
     * @Date 12:55 上午 2022/7/2
     * @Param [from_id, amt]
     * @return void
     **/
    @Transactional(propagation= Propagation.NESTED)
    @Override
    public void addFreeInfo(String from_id, Double amt) {
        Double free = amt * 0.001;
        freeMapper.addFreeInfo(from_id,free);
    }
}
