package site.mizhuo.designpattern.state;

/**
 * @ClassName Context
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 16:30
 * @Version 1.0
 **/
public class Context {

    private State state;

    public Context() {
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
