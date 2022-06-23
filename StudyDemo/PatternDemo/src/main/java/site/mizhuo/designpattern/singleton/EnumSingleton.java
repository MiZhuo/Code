package site.mizhuo.designpattern.singleton;

/**
 * @EnumName EnumSingleton
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 17:30
 * @Version 1.0
 **/
public enum EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}
