package site.mizhuo.code;


/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPerfectSquare {
    /**
     * 二分法
     * 执行用时 :1 ms, 在所有 Java 提交中击败了95.25%的用户
     * 内存消耗 :33.6 MB, 在所有 Java 提交中击败了11.05%的用户
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        int mid = start + (end - start) / 2;
        while(start <= end)
        {
            if(Math.pow(mid,2) > num) {
                end = mid - 1;
            } else if(Math.pow(mid,2) < num) {
                start = mid + 1;
            } else {
                return true;
            }
            mid = (end - start) / 2 + start;
        }
        return false;
    }
}