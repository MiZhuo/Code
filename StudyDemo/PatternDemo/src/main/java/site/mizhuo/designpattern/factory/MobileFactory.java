package site.mizhuo.designpattern.factory;

/**
 * @ClassName MobileFactory
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-23 22:15
 * @Version 1.0
 **/
public class MobileFactory {
    public static Mobile productionAppleMobile(){
        return new ApplePhone();
    }
    public static Mobile productionHuaWeiMobile(){
        return new HuaWeiPhone();
    }
}
