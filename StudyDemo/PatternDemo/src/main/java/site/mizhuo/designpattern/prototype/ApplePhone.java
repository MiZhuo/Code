package site.mizhuo.designpattern.prototype;

/**
 * @ClassName Iphone
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-30 21:49
 * @Version 1.0
 **/
public class ApplePhone extends Mobile{

    public ApplePhone(){
        type = "iphone";
    }

    @Override
    public void mobileModel() {
        System.out.println("iPhone 11，A13处理器");
    }
}
