package site.mizhuo.designpattern.memento;

/**
 * @ClassName Game
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 22:30
 * @Version 1.0
 **/
public class Game {
    private String status;

    public Game(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
