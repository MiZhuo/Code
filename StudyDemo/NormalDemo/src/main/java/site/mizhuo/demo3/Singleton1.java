package site.mizhuo.demo3;

/**
 * @author: Mizhuo
 * @time: 2021/3/11 10:25 下午
 * @description: 单例模式饿汉式
 */
public class Singleton1 {
    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance(){
        return singleton1;
    }
}
