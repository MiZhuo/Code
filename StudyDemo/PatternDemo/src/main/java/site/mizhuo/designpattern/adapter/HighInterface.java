package site.mizhuo.designpattern.adapter;

/**
 * @ClassName Hdmi
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-30 22:36
 * @Version 1.0
 **/
public interface HighInterface {

    public void charge(String interfaceName);

    public void transferFiles(String interfaceName);

    public void show(String interfaceName);
}
