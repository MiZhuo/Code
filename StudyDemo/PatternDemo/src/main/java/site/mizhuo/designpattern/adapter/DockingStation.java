package site.mizhuo.designpattern.adapter;

/**
 * @ClassName DockingStation
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-31 19:51
 * @Version 1.0
 **/
public class DockingStation implements Interface{
    InterfaceAdapter adapter;

    @Override
    public void function(String interfaceType, String interfaceName) {
        adapter = new InterfaceAdapter(interfaceType);
        adapter.function(interfaceType,interfaceName);
    }
}
