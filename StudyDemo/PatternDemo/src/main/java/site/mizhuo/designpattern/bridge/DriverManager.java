package site.mizhuo.designpattern.bridge;

/**
 * @ClassName DriverManager
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-01 22:36
 * @Version 1.0
 **/
public abstract class DriverManager{
    protected Jdbc jdbc;

    protected DriverManager(Jdbc jdbc) {
        this.jdbc = jdbc;
    }

    public abstract void connectDB();
}
