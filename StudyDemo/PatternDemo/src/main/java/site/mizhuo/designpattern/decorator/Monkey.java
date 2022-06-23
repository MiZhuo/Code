package site.mizhuo.designpattern.decorator;

/**
 * @ClassName Monkey
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-05 17:06
 * @Version 1.0
 **/
public class Monkey implements Animal{

    @Override
    public void abilities() {
        System.out.println("Monkey:吃桃子、爬树");
    }
}
