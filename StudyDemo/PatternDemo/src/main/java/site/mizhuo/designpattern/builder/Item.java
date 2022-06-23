package site.mizhuo.designpattern.builder;

/**
 * @ClassName Item
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-29 17:52
 * @Version 1.0
 **/
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
