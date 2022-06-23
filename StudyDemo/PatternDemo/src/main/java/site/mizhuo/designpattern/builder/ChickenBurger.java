package site.mizhuo.designpattern.builder;

/**
 * @ClassName ChickenBurger
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 18:00
 * @Version 1.0
 **/
public class ChickenBurger extends Burger{
    @Override
    public String name() {
        return "鸡肉汉堡";
    }

    @Override
    public float price() {
        return 15.0f;
    }
}
