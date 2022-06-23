package site.mizhuo.seatademobank2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.mizhuo.seatademobank2.service.CustDepDetailService;

/**
 * @author: Mizhuo
 * @time: 2021/3/31 10:40 下午
 * @description:
 */
@RestController
@RequestMapping("/bank2")
public class TransferController {

    @Autowired
    CustDepDetailService custDepDetailService;

    @GetMapping("/transfer")
    public String transfer(@RequestParam double amount){
        custDepDetailService.updateCustDepBal(1,amount);
        return "success";
    }
}
