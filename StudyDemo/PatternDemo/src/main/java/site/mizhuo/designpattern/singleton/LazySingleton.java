package site.mizhuo.designpattern.singleton;

/**
 * @ClassName singleton1
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 16:47
 * @Version 1.0
 **/
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){};
    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
