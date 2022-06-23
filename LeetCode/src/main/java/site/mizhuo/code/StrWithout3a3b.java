package site.mizhuo.code;

/**
 * Create by wulibin on 2019/6/17
 *
 * @describle
 * 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
 *
 * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 * 子串 'aaa' 没有出现在 S 中；
 * 子串 'bbb' 没有出现在 S 中。
 *  
 *
 * 示例 1：
 *
 * 输入：A = 1, B = 2
 * 输出："abb"
 * 解释："abb", "bab" 和 "bba" 都是正确答案。
 * 示例 2：
 *
 * 输入：A = 4, B = 1
 * 输出："aabaa"
 *
 */
public class StrWithout3a3b {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        int diff = A - B;
        boolean flag = false;
        char insert = A > B ? 'a' : 'b';
        for(int i = 0, iMax = A + B;i < iMax;i++) {
            sb.append(insert);
            if(flag) {
                flag = false;
                insert = insert == 'a' ? 'b' : 'a';
            } else if(diff > 0 && insert == 'a') {
                flag = true;
                diff--;
            } else if(diff < 0 && insert == 'b') {
                flag = true;
                diff++;
            } else {
                insert = insert == 'a' ? 'b' : 'a';
            }
        }
        return sb.toString();
    }
}