package site.mizhuo.designpattern.bridge;

/**
 * @ClassName MysqlDriver
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-01 22:34
 * @Version 1.0
 **/
public class MysqlDriver implements Jdbc{
    @Override
    public void connectDB() {
        System.out.println("连接Mysql数据库");
    }
}
