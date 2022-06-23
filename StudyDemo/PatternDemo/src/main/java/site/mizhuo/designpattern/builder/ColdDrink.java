package site.mizhuo.designpattern.builder;

/**
 * @ClassName ColdDrink
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 17:58
 * @Version 1.0
 **/
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
