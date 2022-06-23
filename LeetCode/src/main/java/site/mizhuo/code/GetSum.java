package site.mizhuo.code;

/**
 * @author MiZhuo
 * @Description:
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-07-29 21:29
 */
public class GetSum {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.3 MB, 在所有 Java 提交中击败了20.65%的用户
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a^b,(a&b)<<1);
    }
}
