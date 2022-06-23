package site.mizhuo.designpattern.interpreter;

/**
 * @InterfaceName Expression
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-11 15:50
 * @Version 1.0
 **/
public interface Expression {
    int interpreter(Context context);
}
