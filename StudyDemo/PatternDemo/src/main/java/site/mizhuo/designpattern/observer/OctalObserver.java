package site.mizhuo.designpattern.observer;

/**
 * @ClassName OctalObserver
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 11:05
 * @Version 1.0
 **/
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("八进制:" + Integer.toOctalString(subject.getState()));
    }
}
