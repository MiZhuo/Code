package site.mizhuo.designpattern.adapter;

/**
 * @ClassName Monitor
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-31 19:13
 * @Version 1.0
 **/
public class Hdmi implements HighInterface{
    @Override
    public void charge(String interfaceName) {

    }

    @Override
    public void transferFiles(String interfaceName) {

    }

    @Override
    public void show(String monitor) {
        System.out.println("连接显示器:" + monitor);
    }
}
