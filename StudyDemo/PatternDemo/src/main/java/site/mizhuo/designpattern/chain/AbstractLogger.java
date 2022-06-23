package site.mizhuo.designpattern.chain;

/**
 * @ClassName AbstractLogger
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 14:44
 * @Version 1.0
 **/
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }
    public void log(int level,String message){
        if(this.level <= level){
            write(message);
        }
        if(nextLogger != null){
            nextLogger.log(level,message);
        }
    }

    protected abstract void write(String message);
}
