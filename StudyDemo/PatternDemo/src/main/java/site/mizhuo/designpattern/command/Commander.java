package site.mizhuo.designpattern.command;

/**
 * @ClassName Commander
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 15:16
 * @Version 1.0
 **/
public class Commander {
    private Command command;

    public Commander(Command command) {
        this.command = command;
    }

    public void pushCommand(){
        System.out.println("司令发出命令。。。");
        command.execute();
    }
}
