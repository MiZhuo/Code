package site.mizhuo.designpattern.builder;

/**
 * @ClassName Pepsi
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 18:02
 * @Version 1.0
 **/
public class Pepsi extends ColdDrink{
    @Override
    public String name() {
        return "百事可乐";
    }

    @Override
    public float price() {
        return 4.5f;
    }
}
