package site.mizhuo.seatademobank1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.mizhuo.seatademobank1.service.CustDepDetailService;

/**
 * @author: Mizhuo
 * @time: 2021/3/29 10:26 下午
 * @description:
 */
@RestController
@RequestMapping("/bank1")
public class TransferController {

    @Autowired
    CustDepDetailService custDepDetailService;

    @GetMapping("/transfer")
    public String transfer(@RequestParam Integer id,@RequestParam double amount){
        String res = custDepDetailService.transfer(id,amount);
        return "zhangsan->lisi:" + amount;
    }

}
