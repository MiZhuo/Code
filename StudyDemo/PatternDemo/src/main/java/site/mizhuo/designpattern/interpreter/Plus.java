package site.mizhuo.designpattern.interpreter;

/**
 * @ClassName Plus
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 15:51
 * @Version 1.0
 **/
public class Plus implements Expression{
    @Override
    public int interpreter(Context context) {
        return context.getNum1() + context.getNum2();
    }
}
