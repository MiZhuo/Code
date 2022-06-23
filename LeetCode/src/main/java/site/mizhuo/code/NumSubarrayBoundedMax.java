package site.mizhuo.code;

/**
 * @author MiZhuo
 * @Description:
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 *
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 *
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-08-10 12:16
 */
public class NumSubarrayBoundedMax {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int t1 = 0,t2 = 0;
        int n = A.length;
        for(int i = 0,j = 0;i < n;){
            if(A[i] <= R){
                ++ i;
                t1 += i-j;
            } else {
                ++ i;
                j = i;
            }
        }
        for(int i = 0,j = 0;i < n;){
            if(A[i] < L){
                ++ i;
                t2 += i - j;
            }else {
                ++ i;
                j = i;
            }
        }
        return t1 - t2;
    }

}
