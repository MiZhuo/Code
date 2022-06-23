package site.mizhuo.designpattern.adapter;

/**
 * @ClassName DockingStationAdapter
 * @Description: 扩展坞
 * @Author: MiZhuo
 * @Create: 2021-08-31 19:15
 * @Version 1.0
 **/
public class InterfaceAdapter implements Interface{
    HighInterface inter;

    public InterfaceAdapter(String interfaceType){
        if("typeC-T".equalsIgnoreCase(interfaceType) || "typeC-E".equalsIgnoreCase(interfaceType) ){
            inter = new TypeC();
        }else if("hdmi".equalsIgnoreCase(interfaceType)){
            inter = new Hdmi();
        }
    }

    @Override
    public void function(String interfaceType, String interfaceName) {
        if("typeC-E".equalsIgnoreCase(interfaceType)){
            inter.charge(interfaceName);
        }else if("typeC-T".equalsIgnoreCase(interfaceType)){
            inter.transferFiles(interfaceName);
        }else if("hdmi".equalsIgnoreCase(interfaceType)){
            inter.show(interfaceName);
        }
    }
}
