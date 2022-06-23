package site.mizhuo.code;

/**
 * @author: Mizhuo
 * @time: 2020/4/3 1:56 下午
 * @description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarraymyAtoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int len = nums.length, maxSum = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
