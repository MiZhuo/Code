package site.mizhuo.designpattern.templete;

/**
 * @ClassName Edge
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 16:06
 * @Version 1.0
 **/
public class Edge extends Chromium{

    @Override
    void initialize() {
        System.out.println("欢迎使用Microsoft Edge浏览器!");
    }

    @Override
    void expand() {
        System.out.println("登陆Microsoft账号，同步数据。");
    }

    @Override
    void online() {
        System.out.println("使用Microsoft Edge浏览器上网。");
    }
}
