package site.mizhuo.designpattern.proxy;

/**
 * @ClassName MySelfRentHouse
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-09 22:32
 * @Version 1.0
 **/
public class MySelfRentHouse implements RentHouse{

    private String tenant;

    public MySelfRentHouse(String tenant) {
        this.tenant = tenant;
    }

    @Override
    public void rentHouse() {
        System.out.println(tenant + "入住。。。");
    }

    @Override
    public void findHouse(){
        System.out.println(tenant + "网上找。。。");
        System.out.println(tenant + "街上找。。。");
        System.out.println(tenant + "约房东见面。。。");
        System.out.println(tenant + "找到了。。。");
        System.out.println(tenant + "办手续。。。");
    }
}
