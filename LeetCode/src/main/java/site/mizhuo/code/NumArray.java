package site.mizhuo.code;

/**
 * @author: Mizhuo
 * @time: 2020/4/21 4:11 下午
 * @description: 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumArray {
    private int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i <= 0) {
            return dp[j];
        }
        return dp[j] - dp[i - 1];
    }
}
