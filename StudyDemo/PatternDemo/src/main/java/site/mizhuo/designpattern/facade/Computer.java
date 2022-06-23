package site.mizhuo.designpattern.facade;

/**
 * @ClassName Computer
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-06 22:02
 * @Version 1.0
 **/
public class Computer {
    private Cpu cpu;
    private Memory memory ;
    private Disk disk;

    public Computer() {
        cpu = new Cpu();
        memory = new Memory();
        disk = new Disk();
    }

    public void startUp(){
        System.out.println("电脑开始启动....");
        cpu.startUp();
        memory.startUp();
        disk.startUp();
        System.out.println("电脑启动成功!");
    }

    public void shutDown(){
        System.out.println("电脑开始关闭....");
        cpu.shutDown();
        memory.shutDown();
        disk.shutDown();
        System.out.println("电脑关闭成功!");
    }
}
