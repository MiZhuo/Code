package site.mizhuo.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MiZhuo
 * @Description:
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 *
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 *
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 *
 *  
 *
 * 示例 1:
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 示例 2:
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 * 解释:
 * 0.0, 00, 0001 或 00.01 是不被允许的。
 * 示例 3:
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * 示例 4:
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:
 * 1.0 是不被允许的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ambiguous-coordinates
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-07-28 11:27
 */
public class AmbiguousCoordinates {
    /**
     * 执行用时 :22 ms, 在所有 Java 提交中击败了30.23%的用户
     * 内存消耗 :48.5 MB, 在所有 Java 提交中击败了41.67%的用户
     * @param
     * @return
     */
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1,S.length() - 1);
        List<String> list = new ArrayList<>();
        int subIndex = 1;
        while (subIndex < S.length()){//从位置1开始切割字符串
            String left = S.substring(0,subIndex);
            String right = S.substring(subIndex,S.length());
            int rightPointIndex = 0;
            String tempLeft = left;
            //给左边的坐标添加小数点
            while (!tempLeft.endsWith(".")){
                if(allow(tempLeft)){//如果左边坐标合法，再给右边的坐标添加坐标点
                    int leftPointIndex = 1;
                    String tempRight = right;
                    while (!tempRight.endsWith(".")){
                        if(allow(tempRight)){//左右坐标均合法则添加到list中
                            list.add("(" + tempLeft + ", " + tempRight + ")");
                        }
                        tempRight = right.substring(0,leftPointIndex) + "." + right.substring(leftPointIndex,right.length());
                        leftPointIndex ++;
                    }
                }
                tempLeft = left.substring(0,rightPointIndex) + "." + left.substring(rightPointIndex,left.length());
                rightPointIndex ++;
            }
            subIndex ++;
        }
        return list;
    }

    /**
     * 判断坐标值是否合法
     * @param source
     * @return
     */
    public boolean allow(String source){
        boolean flag = true;
        if(source.length() == 1){
            if(!source.equals(".")) {
                flag = true;
            }
        }else if(source.length() <  1){
            flag = false;
        }else{
            if(source.contains(".")){
                if(source.startsWith(".") || source.endsWith("0") || source.startsWith("00") || (source.substring(0,source.indexOf('.')).length() > 1 && source.substring(0,source.indexOf('.')).startsWith("0"))){
                    flag = false;
                }
            }else{
                if(source.startsWith("0")){
                    flag = false;
                }
            }
        }
        return flag;
    }
}

