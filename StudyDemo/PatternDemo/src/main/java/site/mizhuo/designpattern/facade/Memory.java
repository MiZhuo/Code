package site.mizhuo.designpattern.facade;

/**
 * @ClassName Memerory
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-06 22:00
 * @Version 1.0
 **/
public class Memory implements HardWare{
    @Override
    public void startUp() {
        System.out.println("Memory启动...");
    }

    @Override
    public void shutDown() {
        System.out.println("Memory关闭...");
    }
}
