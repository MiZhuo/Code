package site.mizhuo.code;

/**
 * Create by wulibin on 2019/7/30
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Integer.MIN_VALUE;
        double temp = 0;
        for(int i = 0;i < nums.length;i++){
            if(i < k){
                temp += nums[i];
                maxSum = temp;
            }else{
                temp = temp - nums[i - k] + nums[i];
                if(temp > maxSum){
                    maxSum = temp;
                }
            }
        }
        return maxSum / k;
    }
}
