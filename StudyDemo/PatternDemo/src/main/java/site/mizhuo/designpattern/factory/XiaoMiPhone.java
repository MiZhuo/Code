package site.mizhuo.designpattern.factory;

/**
 * @ClassName ApplePhone
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-23 22:14
 * @Version 1.0
 **/
public class XiaoMiPhone implements Mobile {
    @Override
    public void mobileInfo() {
        System.out.println("XiaoMi,Mix4,骁龙888+");
    }
}
