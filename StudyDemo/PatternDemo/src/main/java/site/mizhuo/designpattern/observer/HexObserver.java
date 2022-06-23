package site.mizhuo.designpattern.observer;

/**
 * @ClassName HexObserver
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 11:05
 * @Version 1.0
 **/
public class HexObserver extends Observer{

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("十六进制:" + Integer.toHexString(subject.getState()));
    }
}
