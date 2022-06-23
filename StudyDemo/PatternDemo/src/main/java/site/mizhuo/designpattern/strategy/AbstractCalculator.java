package site.mizhuo.designpattern.strategy;

/**
 * @ClassName AbstractCalcutor
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-12 12:03
 * @Version 1.0
 **/
public abstract class AbstractCalculator {

    public int[] split(String exp,String opt){
        String[] arr = exp.split(opt);
        int[] arrInt = new int[2];
        arrInt[0] = Integer.parseInt(arr[0]);
        arrInt[1] = Integer.parseInt(arr[1]);
        return arrInt;
    }
}
