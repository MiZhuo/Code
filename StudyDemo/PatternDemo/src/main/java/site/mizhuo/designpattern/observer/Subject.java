package site.mizhuo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 10:51
 * @Version 1.0
 **/
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        observers.forEach(Observer::update);
    }
}
