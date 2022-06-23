package site.mizhuo.designpattern.factory;

/**
 * @ClassName ApplePhone
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-23 22:14
 * @Version 1.0
 **/
public class ApplePhone implements Mobile {
    @Override
    public void mobileInfo() {
        System.out.println("Apple,iphone11,A13");
    }
}
