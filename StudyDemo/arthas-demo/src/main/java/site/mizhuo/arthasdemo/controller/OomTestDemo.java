package site.mizhuo.arthasdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @ClassName: OomTestDemo
 * @Author: MiZhuo
 * @Date: 2022/7/15 21:22
 * @Description: TODO
 */
@RestController
@RequestMapping("/oom")
public class OomTestDemo {

    @RequestMapping("/test")
    public String oomTest(){
        ArrayList<Object> list = new ArrayList<>(100000);
        while (true) {
            list.add(new Object());
        }
    }
}
