package site.mizhuo.designpattern.prototype;

/**
 * @ClassName Iphone
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-30 21:49
 * @Version 1.0
 **/
public class HuaWeiPhone extends Mobile{

    public HuaWeiPhone(){
        type = "huawei";
    }

    @Override
    public void mobileModel() {
        System.out.println("华为Mate40 Pro，麒麟990 5G");
    }
}
