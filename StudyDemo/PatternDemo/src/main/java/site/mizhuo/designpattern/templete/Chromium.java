package site.mizhuo.designpattern.templete;

/**
 * @ClassName Chromium
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 16:03
 * @Version 1.0
 **/
public abstract class Chromium {
    abstract void initialize();

    abstract void expand();

    abstract void online();

    public final void useBrowser(){
        initialize();
        expand();
        online();
    }
}
