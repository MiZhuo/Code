package site.mizhuo.designpattern.prototype;

/**
 * @ClassName Iphone
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-30 21:49
 * @Version 1.0
 **/
public class XiaoMiPhone extends Mobile{

    public XiaoMiPhone(){
        type = "xiaomi";
    }

    @Override
    public void mobileModel() {
        System.out.println("小米Mix4，骁龙888+");
    }
}
