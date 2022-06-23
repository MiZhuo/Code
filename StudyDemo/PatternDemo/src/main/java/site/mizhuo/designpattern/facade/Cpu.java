package site.mizhuo.designpattern.facade;

/**
 * @ClassName Cpu
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-06 21:58
 * @Version 1.0
 **/
public class Cpu implements HardWare{
    @Override
    public void startUp() {
        System.out.println("CPU启动...");
    }

    @Override
    public void shutDown() {
        System.out.println("CPU关闭...");
    }
}
