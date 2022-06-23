package site.mizhuo.designpattern.decorator;

/**
 * @ClassName Pig
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-05 17:09
 * @Version 1.0
 **/
public class Pig implements Animal{
    @Override
    public void abilities() {
        System.out.println("Pig:吃剩饭剩菜、睡觉");
    }
}
