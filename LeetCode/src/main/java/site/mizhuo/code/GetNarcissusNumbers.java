package site.mizhuo.code;

import java.util.ArrayList;
import java.util.List;

public class GetNarcissusNumbers {
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n);
        //若n为1时，此时start应为0
        if (n == 1) {
            start = 0;
        }
        for (int i = start; i < end; i++) {
            if (isNarNum(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isNarNum(int number) {
        String str = String.valueOf(number);
        char[] temp = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += (int) Math.pow((temp[i] - '0'), temp.length);//char '1'转换为int 结果为46，因此此处均要减'0'
        }
        if (number == sum)
            return true;
        return false;
    }
}
