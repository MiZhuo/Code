package site.mizhuo.designpattern.visitor;

/**
 * @InterfaceName Visitor
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 18:00
 * @Version 1.0
 **/
public interface Visitor {

    void visit(Programmer programmer);

    void visit(Manager manager);
}
