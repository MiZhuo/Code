package site.mizhuo.designpattern.strategy;

/**
 * @ClassName Plus
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 12:06
 * @Version 1.0
 **/
public class Plus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] arr = split(exp,"\\+");
        return arr[0] + arr[1];
    }
}
