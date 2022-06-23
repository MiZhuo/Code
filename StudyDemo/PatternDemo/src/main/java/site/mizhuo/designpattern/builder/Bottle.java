package site.mizhuo.designpattern.builder;

/**
 * @ClassName Bottle
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 17:55
 * @Version 1.0
 **/
public class Bottle implements Packing{
    @Override
    public String pack() {
        return "瓶装";
    }
}
