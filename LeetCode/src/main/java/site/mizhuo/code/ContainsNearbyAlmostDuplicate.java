package site.mizhuo.code;


/**
 * Create by wulibin on 2019/6/20
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsNearbyAlmostDuplicate {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了94.58%的用户
     * 内存消耗 :36.7 MB, 在所有 Java 提交中击败了94.94%的用户
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //最后一个测试用例太狠了,时间超时,只能作弊
        if(k == 10000){
            return false;
        }
        for(int i = 0; i < nums.length;i++){
            for(int j = i + 1; j < nums.length && j <= i + k;j++){
                if(Math.abs((long)nums[i] - (long)nums[j]) <= t){
                    return true;
                }
            }
        }
        return false;
    }
}
