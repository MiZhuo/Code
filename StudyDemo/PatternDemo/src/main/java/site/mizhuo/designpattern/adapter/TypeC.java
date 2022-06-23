package site.mizhuo.designpattern.adapter;

/**
 * @ClassName Macbook
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-31 18:57
 * @Version 1.0
 **/
public class TypeC implements HighInterface{

    @Override
    public void charge(String interfaceName) {
        System.out.println("充电");
    }

    @Override
    public void transferFiles(String interfaceName) {
        System.out.println("文件传输");
    }

    @Override
    public void show(String interfaceName) {

    }
}
