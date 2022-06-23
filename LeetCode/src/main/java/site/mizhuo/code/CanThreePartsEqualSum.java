package site.mizhuo.code;

/**
 * Create by wulibin on 2019/5/31
 * @description
 * Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
 *
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 *
 *
 *
 * Example 1:
 *
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * Example 2:
 *
 * Input: [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 * Example 3:
 *
 * Input: [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 */
public class CanThreePartsEqualSum {
    /**
     * 执行用时 : 3 ms, 在Partition Array Into Three Parts With Equal Sum的Java提交中击败了96.07% 的用户
     * 内存消耗 : 53 MB, 在Partition Array Into Three Parts With Equal Sum的Java提交中击败了42.45% 的用户
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0,mid = 0,temp = 0,i = 0,j = 0;
        for (int a : A) {
            sum += a;
        }
        if(sum % 3 != 0){
            return false;
        }
        mid = sum / 3;
        for (i = 0; i < A.length; i++) {
            temp += A[i];
            if(temp == mid){
                break;
            }
        }
        temp = 0;
        for (j = A.length - 1;j > 0; j--) {
            temp += A[j];
            if(temp == mid){
                break;
            }
        }
        if( i >= j ) {
            return false;
        }
        return true;
    }

    /**
     * 执行用时 : 3 ms, 在Partition Array Into Three Parts With Equal Sum的Java提交中击败了96.07% 的用户
     * 内存消耗 : 48.1 MB, 在Partition Array Into Three Parts With Equal Sum的Java提交中击败了99.30% 的用户
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum2(int[] A) {
        /*思路：先求总和，求平均，判断存不存在和相等的三部分*/
        int sum = 0, mid = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }
        mid = sum / 3;
        int count = 0;
        int temp = 0;
        for (int i = 0; i < A.length; ++i) {
            temp += A[i];
            if (temp == mid) {
                count++;
                temp = 0;
            }

        }
        return count == 3;
    }
}
