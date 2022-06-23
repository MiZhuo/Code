package site.mizhuo.designpattern.mediator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName WeChartGroup
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 21:49
 * @Version 1.0
 **/
public class WeChartGroup {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void chart(User user,String message){
        System.out.println(df.format(new Date()) + "[" + user.getName() + ":" + message + "]");
    }
}
