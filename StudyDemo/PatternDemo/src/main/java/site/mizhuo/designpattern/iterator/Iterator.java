package site.mizhuo.designpattern.iterator;

/**
 * @InterfaceName Iterator
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 18:20
 * @Version 1.0
 **/
public interface Iterator {

    Object previous();

    Object next();

    boolean hasNext();

    Object first();

    Object last();
}
