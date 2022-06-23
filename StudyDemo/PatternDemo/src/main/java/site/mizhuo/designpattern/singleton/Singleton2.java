package site.mizhuo.designpattern.singleton;

/**
 * @ClassName singleton1
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 16:47
 * @Version 1.0
 **/
public class Singleton2 {
    private static class SingletonHolder{
        private final static Singleton2 INSTANCE = new Singleton2();
    }

    private Singleton2(){};
    public static Singleton2 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
