package site.mizhuo.code;

/**
 * @author: wulibin
 * @date: 2019\5\16 0016
 * @description:
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 *
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 *
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 */
public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        if(nums.length < 3){
            return true;
        }
        int count = 0;
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] > nums[i + 1]){
                count++;
                if(count > 1){
                    return false;
                }
                if(i - 1 > -1 && nums[i - 1] > nums[i + 1] && i + 2 < nums.length && nums[i] > nums[i + 2] ){
                    return false;
                }
            }
        }
        return true;
    }
}
