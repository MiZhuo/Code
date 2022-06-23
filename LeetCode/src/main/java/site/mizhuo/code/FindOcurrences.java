package site.mizhuo.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by wulibin on 2019/8/1
 */
public class FindOcurrences {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了90.48%的用户
     * 内存消耗 :35.1 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOcurrences(String text, String first, String second) {
        String[] res = text.split(" ");
        List<String> list = new ArrayList<>();
        for(int i = 0;i < res.length - 2;i++){
            if(first.equals(res[i]) && second.equals(res[i + 1])){
                list.add(res[i + 2]);
            }
        }
        return  list.toArray(new String[list.size()]);
    }
}
