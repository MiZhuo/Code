package site.mizhuo.designpattern.chain;

/**
 * @ClassName FileLogger
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 14:48
 * @Version 1.0
 **/
public class FileLogger extends AbstractLogger{

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("输出消息到文件:" + message);
    }
}
