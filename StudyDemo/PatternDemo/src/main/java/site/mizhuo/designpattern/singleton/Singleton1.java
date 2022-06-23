package site.mizhuo.designpattern.singleton;

/**
 * @ClassName singleton1
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 16:47
 * @Version 1.0
 **/
public class Singleton1 {
    private static Singleton1 singleton1 = new Singleton1();
    private Singleton1(){};
    public static Singleton1 getInstance(){
        return singleton1;
    }
}
