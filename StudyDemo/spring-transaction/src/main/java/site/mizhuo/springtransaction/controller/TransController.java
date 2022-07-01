package site.mizhuo.springtransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.mizhuo.springtransaction.service.ITransService;
/**
 * @ClassName TransController
 * @Description:
 * @Author: MiZhuo
 * @Create: 2022-06-30 21:57
 * @Version 1.0
 **/
@RequestMapping("/trans")
@RestController
public class TransController {
    @Autowired
    private ITransService transService;

    @GetMapping("/trade")
    public String trans(String from_id,String to_id,Double amt){
        transService.trans(from_id,to_id,amt);
        return "success";
    }
}