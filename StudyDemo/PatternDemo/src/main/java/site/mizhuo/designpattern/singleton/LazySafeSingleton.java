package site.mizhuo.designpattern.singleton;

/**
 * @ClassName singleton1
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 16:47
 * @Version 1.0
 **/
public class LazySafeSingleton {
    private static LazySafeSingleton instance;
    private LazySafeSingleton(){};
    public static LazySafeSingleton getInstance(){
        if(instance == null){
            synchronized(instance){
                if(instance == null) {
                    instance = new LazySafeSingleton();
                }
            }
        }
        return instance;
    }
}
