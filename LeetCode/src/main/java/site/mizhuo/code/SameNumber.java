package site.mizhuo.code;

/**
 * Given an array, If the same number exists in the array, and the distance of the same number is less than the given value k, output YES, otherwise output NO.
 *
 * 样例
 * Example1
 *
 * Input:  array = [1,2,3,1,5,9,3] and k = 4
 * Output: "YES"
 * Explanation:
 * The distance of 1 whose indexes are  3 and 0 is 3, which meets the requirement and output YES.
 * Example2
 *
 * Input:  array = [1,2,3,5,7,1,5,1,3] and k = 4
 * Output: "YES"
 * Explanation:
 * The distance of 1 whose indexes are 0 and 5 is 5, which meets the requirement， and output YES.
 */
public class SameNumber {
    public String sameNumber(int[] nums, int k) {
        // Write your code here
        boolean b = false;
        for (int i = 0;i < nums.length;i++) {
            for (int j = 0 ;j < nums.length;j++){
                if(nums[i] == nums[j] && i != j){
                    if((j - i) < k && (j - i) > 0){
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }
}
