package site.mizhuo.code;

/**
 * @author: WuLiBin
 * @date: 2019\6\12 0012
 * @description:
 */

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 *
 */

/**
 * 执行用时 :1 ms, 在所有Java提交中击败了79.74%的用户
 * 内存消耗 :33.7 MB, 在所有Java提交中击败了89.39%的用户
 */
public class CountSegments {
    public int countSegments(String s) {
        int res = 0;
        s = s + " ";
        for(int i = 0;i < s.length() - 1;i++){
            if(s.charAt(i) != ' ' && s.charAt(i + 1) == ' '){
                res ++;
            }
        }
        return res;
    }
}
