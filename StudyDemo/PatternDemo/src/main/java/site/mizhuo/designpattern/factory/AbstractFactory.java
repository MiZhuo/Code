package site.mizhuo.designpattern.factory;

/**
 * @ClassName AbstractFactory
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-24 20:35
 * @Version 1.0
 **/
public abstract class AbstractFactory {
    public abstract Mobile producationMobile();

    public abstract Computer producationComputer();
}
