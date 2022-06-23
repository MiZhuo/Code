package site.mizhuo.designpattern.bridge;

/**
 * @ClassName MyDriverManager
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-01 22:55
 * @Version 1.0
 **/
public class MyDriverManager extends DriverManager{

    public MyDriverManager(Jdbc jdbc) {
        super(jdbc);
    }

    @Override
    public void connectDB() {
        jdbc.connectDB();
    }
}
