package site.mizhuo.designpattern.state;

/**
 * @ClassName StateA
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 16:31
 * @Version 1.0
 **/
public class StateB implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("状态B");
        context.setState(this);
    }
}
