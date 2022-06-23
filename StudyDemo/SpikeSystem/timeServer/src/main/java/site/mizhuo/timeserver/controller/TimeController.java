package site.mizhuo.timeserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TimeController
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-06 10:06
 * @Version 1.0
 **/
@RestController
public class TimeController {

    @GetMapping("/getTime")
    public String getTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
