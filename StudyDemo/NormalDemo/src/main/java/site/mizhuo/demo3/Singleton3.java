package site.mizhuo.demo3;

/**
 * @author: Mizhuo
 * @time: 2021/3/11 10:30 下午
 * @description: 单例模式-懒汉式-线程安全
 */
public class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if(singleton3 == null){
            synchronized (Singleton3.class){
                if(singleton3 == null){
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
