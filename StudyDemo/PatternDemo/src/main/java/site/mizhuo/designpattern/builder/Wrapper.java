package site.mizhuo.designpattern.builder;

/**
 * @ClassName Wrapper
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 17:54
 * @Version 1.0
 **/
public class Wrapper implements Packing{
    @Override
    public String pack() {
        return "盒装";
    }
}
