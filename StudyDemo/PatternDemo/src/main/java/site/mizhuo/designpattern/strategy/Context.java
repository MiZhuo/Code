package site.mizhuo.designpattern.strategy;

/**
 * @ClassName Context
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 12:10
 * @Version 1.0
 **/
public class Context {
    ICalculator calculate;

    public Context(ICalculator calculate) {
        this.calculate = calculate;
    }

    public int executeOptions(String exp){
        return calculate.calculate(exp);
    }
}
