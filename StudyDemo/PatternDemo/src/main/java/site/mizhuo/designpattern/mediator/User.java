package site.mizhuo.designpattern.mediator;

/**
 * @ClassName User
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 21:50
 * @Version 1.0
 **/
public class User {
    private String name ;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        WeChartGroup.chart(this,message);
    }

}
