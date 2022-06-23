package site.mizhuo.designpattern.visitor;

/**
 * @ClassName CEOVisitor
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 18:10
 * @Version 1.0
 **/
public class CEOVisitor implements Visitor{
    @Override
    public void visit(Programmer programmer) {
        System.out.println("程序员:" + programmer.getName() + ",KPI:" + programmer.getKpi());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理:" + manager.getName() + ",KPI:" + manager.getKpi() + ",新产品数量:" + manager.getProducts());
    }
}
