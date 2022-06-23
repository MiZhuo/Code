package site.mizhuo.designpattern.visitor;

import java.util.Random;

/**
 * @ClassName Manager
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 18:04
 * @Version 1.0
 **/
public class Manager extends Staff{

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getProducts() {
        return new Random().nextInt(10);
    }
}
