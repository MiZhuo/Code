package site.mizhuo.designpattern.command;

/**
 * @ClassName MilitaryOrder
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 15:20
 * @Version 1.0
 **/
public class MilitaryOrder implements Command{
    private Soldier soldier;

    public MilitaryOrder(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public void execute() {
        soldier.executeAction();
    }
}
