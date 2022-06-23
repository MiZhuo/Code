package site.mizhuo.code;

/**
 * @author: WuLiBin
 * @date: 2019\5\21 0021
 * @description:
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 *
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 *
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 *
 * Input: [1,1,1]
 * Output: true
 */
public class IsMonotonic {
    /**
     *
     * @param A
     * @description
     * 执行用时 : 5 ms, 在Monotonic Array的Java提交中击败了96.70% 的用户
     * 内存消耗 : 55.2 MB, 在Monotonic Array的Java提交中击败了56.77% 的用户
     */
    public boolean isMonotonic(int[] A) {
        boolean b1 = true,b2 = true;
        //假设是单调递减
        for(int i = 1;i < A.length;i++){
            if(A[i - 1] < A[i]){
                   b1 = false;
                   break;
            }
        }
        for(int i = 1;i < A.length;i++){
            if(A[i - 1] > A[i]){
                b2 = false;
                break;
            }
        }
        return b1 || b2;
    }
}
