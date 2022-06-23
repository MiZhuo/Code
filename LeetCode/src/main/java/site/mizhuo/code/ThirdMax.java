package site.mizhuo.code;

/**
 * Create by wulibin on 2019/6/26
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThirdMax {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.76%的用户
     * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了71.83%的用户
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        long fir = Long.MIN_VALUE,sec = Long.MIN_VALUE,thir = Long.MIN_VALUE;
        for(long n : nums){
            if(n > fir){
                thir = sec;
                sec = fir;
                fir = n;
            }else if(n > sec && n < fir){
                thir = sec;
                sec = n;
            }else if(n > thir && n < sec){
                thir = n;
            }
        }
        if(thir == Long.MIN_VALUE){
            return (int) fir;
        }
        return (int) thir;
    }
}
