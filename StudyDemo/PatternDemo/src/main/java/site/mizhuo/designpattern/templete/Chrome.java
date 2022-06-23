package site.mizhuo.designpattern.templete;

/**
 * @ClassName Chrome
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 16:06
 * @Version 1.0
 **/
public class Chrome extends Chromium{

    @Override
    void initialize() {
        System.out.println("欢迎使用谷歌浏览器!");
    }

    @Override
    void expand() {
        System.out.println("登陆谷歌账号，同步数据。");
    }

    @Override
    void online() {
        System.out.println("使用谷歌浏览器上网。");
    }
}
