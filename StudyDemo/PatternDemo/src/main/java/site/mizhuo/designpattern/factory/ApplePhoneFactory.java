package site.mizhuo.designpattern.factory;

/**
 * @ClassName AppleFactory
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-23 22:46
 * @Version 1.0
 **/
public class ApplePhoneFactory implements MethodFactory{
    @Override
    public Mobile producationMobile() {
        return new ApplePhone();
    }
}
