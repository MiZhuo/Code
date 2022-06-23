package site.mizhuo.designpattern.builder;

/**
 * @ClassName Coke
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 18:01
 * @Version 1.0
 **/
public class Coke extends ColdDrink{
    @Override
    public String name() {
        return "可口可乐";
    }

    @Override
    public float price() {
        return 5.0f;
    }
}
