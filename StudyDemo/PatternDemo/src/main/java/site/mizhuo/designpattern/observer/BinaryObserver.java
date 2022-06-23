package site.mizhuo.designpattern.observer;

/**
 * @ClassName BinaryObserver
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 11:05
 * @Version 1.0
 **/
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("二进制:" + Integer.toBinaryString(subject.getState()));
    }
}
