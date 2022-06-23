package site.mizhuo.designpattern.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName BusinessReport
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 18:05
 * @Version 1.0
 **/
public class BusinessReport {
    private List<Staff> list = new LinkedList<>();

    public BusinessReport() {
        list.add(new Manager("经理A"));
        list.add(new Programmer("张三"));
        list.add(new Programmer("李四"));
        list.add(new Programmer("王五"));
        list.add(new Manager("经理B"));
        list.add(new Programmer("赵六"));
        list.add(new Programmer("孙七"));
    }

    public void showReport(Visitor visitor){
        list.forEach(s -> s.accept(visitor));
    }
}
