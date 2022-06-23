package site.mizhuo.designpattern.chain;

/**
 * @ClassName ErrorLogger
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 14:48
 * @Version 1.0
 **/
public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("输出错误消息:" + message);
    }
}
