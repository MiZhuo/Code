package site.mizhuo.designpattern.builder;

/**
 * @ClassName Burger
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 17:57
 * @Version 1.0
 **/
public abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
