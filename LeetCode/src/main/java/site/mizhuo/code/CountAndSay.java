package site.mizhuo.code;

/**
 * Create by MiZhuo on 2019/8/8
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountAndSay {
    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了74.46%的用户
     * 内存消耗 :34.7 MB, 在所有 Java 提交中击败了85.54%的用户
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = getNextString(res);
        }
        return res;
    }
    public String getNextString(String s){
        if(s.length() == 1){
            return "1" + s;
        }
        StringBuilder sb = new StringBuilder();
        int loop = 1;
        for (int i = 0; i < s.length(); i++) {
            if(i + 1 == s.length()){
                sb.append(loop).append(s.charAt(i));
                break;
            }
            if(s.charAt(i) != s.charAt(i + 1)){
                sb.append(loop).append(s.charAt(i));
                loop = 1;
            }else{
                loop++;
            }
        }
        return sb.toString();
    }
}
