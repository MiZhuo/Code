package site.mizhuo.designpattern.bridge;

/**
 * @ClassName OracleDriver
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-01 22:35
 * @Version 1.0
 **/
public class OracleDriver implements Jdbc{
    @Override
    public void connectDB() {
        System.out.println("连接Oracle数据库");
    }
}
