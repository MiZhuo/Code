package site.mizhuo.code;

public class MaxSubArrayLen {
    /**
     * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
     *
     * 样例
     * Example1
     *
     * Input:  nums = [1, -1, 5, -2, 3], k = 3
     * Output: 4
     * Explanation:
     * because the subarray [1, -1, 5, -2] sums to 3 and is the longest.
     * Example2
     *
     * Input: nums = [-2, -1, 2, 1], k = 1
     * Output: 2
     * Explanation:
     * because the subarray [-1, 2] sums to 1 and is the longest.
     */
    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        int first = 0,max = 0;
        while (first != nums.length - 1) {
            int target = 0;
            for (int i = first; i < nums.length; i++) {
                target += nums[i];
                if (target == k && (i - first + 1) > max) {
                    max = i - first + 1;
                }
            }
            first ++;
        }
        return max;
    }
}
