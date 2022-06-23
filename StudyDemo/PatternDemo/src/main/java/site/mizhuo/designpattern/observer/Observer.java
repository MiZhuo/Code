package site.mizhuo.designpattern.observer;

/**
 * @InterfaceName Observer
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 10:50
 * @Version 1.0
 **/
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
