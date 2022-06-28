package site.mizhuo.seatademobank2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mizhuo.seatademobank2.mapper.CustDepDetailMapper;
import site.mizhuo.seatademobank2.service.CustDepDetailService;

/**
 * @author: Mizhuo
 * @time: 2021/3/31 10:43 下午
 * @description:
 */
@Service
public class CustDepDetailServiceImpl implements CustDepDetailService {
    @Autowired
    CustDepDetailMapper mapper;

    @Override
    public void updateCustDepBal(int i, double amount) {
        mapper.updateCustDepBal(i,amount);
    }
}
