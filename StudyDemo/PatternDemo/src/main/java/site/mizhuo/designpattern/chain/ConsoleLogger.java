package site.mizhuo.designpattern.chain;

/**
 * @ClassName ConsoleLog
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 14:48
 * @Version 1.0
 **/
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("控制台输出消息:" + message);
    }
}
