package site.mizhuo.designpattern.visitor;

import java.util.Random;

/**
 * @ClassName Staff
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 17:58
 * @Version 1.0
 **/
public abstract class Staff {

    private String name;

    private int kpi;

    public Staff(String name) {
        this.name = name;
        this.kpi = new Random().nextInt(10);
    }

    public String getName() {
        return name;
    }

    public int getKpi() {
        return kpi;
    }

    public abstract void accept(Visitor visitor);
}
