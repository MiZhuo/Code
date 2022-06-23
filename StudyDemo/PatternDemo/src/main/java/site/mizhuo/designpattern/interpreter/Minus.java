package site.mizhuo.designpattern.interpreter;

/**
 * @ClassName Minus
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 15:52
 * @Version 1.0
 **/
public class Minus implements Expression{
    @Override
    public int interpreter(Context context) {
        return context.getNum1() - context.getNum2();
    }
}
