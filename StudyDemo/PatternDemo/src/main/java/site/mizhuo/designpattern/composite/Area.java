package site.mizhuo.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Area
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-04 15:56
 * @Version 1.0
 **/
public class Area {
    private String name;
    private List<Area> subAreas;

    public Area(String name) {
        this.name = name;
        this.subAreas = new ArrayList<>();
    }

    public void add(Area area){
        subAreas.add(area);
    }

    public void remove(Area area){
        subAreas.remove(area);
    }

    public List<Area> getSubAreas() {
        return subAreas;
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", subAreas=" + subAreas +
                '}';
    }
}
