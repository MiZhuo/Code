package site.mizhuo.designpattern.builder;

/**
 * @ClassName VegBurger
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 17:59
 * @Version 1.0
 **/
public class VegBurger extends Burger{
    @Override
    public String name() {
        return "蔬菜汉堡";
    }

    @Override
    public float price() {
        return 8.0f;
    }
}
