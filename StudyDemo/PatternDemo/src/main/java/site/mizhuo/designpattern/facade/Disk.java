package site.mizhuo.designpattern.facade;

/**
 * @ClassName Disk
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-06 22:01
 * @Version 1.0
 **/
public class Disk implements HardWare{
    @Override
    public void startUp() {
        System.out.println("Disk启动...");
    }

    @Override
    public void shutDown() {
        System.out.println("Disk关闭...");
    }
}
