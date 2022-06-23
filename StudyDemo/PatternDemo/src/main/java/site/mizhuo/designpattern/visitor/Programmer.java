package site.mizhuo.designpattern.visitor;


import java.util.Random;

/**
 * @ClassName Programmer
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 18:01
 * @Version 1.0
 **/
public class Programmer extends Staff{
    public Programmer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
