package site.mizhuo.designpattern.proxy;

/**
 * @ClassName ProxyRentHouse
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-09 22:34
 * @Version 1.0
 **/
public class ProxyRentHouse implements RentHouse{

    private String rentName;

    private String tenant;

    private MySelfRentHouse house;

    public ProxyRentHouse(String rentName,String tenant) {
        this.rentName = rentName;
        this.tenant = tenant;
        this.house = new MySelfRentHouse(tenant);
    }

    @Override
    public void rentHouse() {
        findHouse();
        house.rentHouse();
        getMoney();
    }

    @Override
    public void findHouse(){
        System.out.println(rentName + "网上找。。。");
        System.out.println(rentName + "街上找。。。");
        System.out.println(rentName + "约房东见面。。。");
        System.out.println(rentName + "找到了。。。");
        System.out.println(rentName + "办手续。。。");
    }

    private void getMoney(){
        System.out.println("收中介费。。。");
    }

}
