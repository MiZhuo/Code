package site.mizhuo.code;

/**
*给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
*
*在此过程之后，我们得到一些数组 B。
*
*返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
*
* 
*
*示例 1：
*
*输入：A = [1], K = 0
*输出：0
*解释：B = [1]
*示例 2：
*
*输入：A = [0,10], K = 2
*输出：6
*解释：B = [2,8]
*示例 3：
*
*输入：A = [1,3,6], K = 3
*输出：0
*解释：B = [3,3,3] 或 B = [4,4,4]
*
*来源：力扣（LeetCode）s
*链接：https://leetcode-cn.com/problems/smallest-range-i
*著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*/
public class SmallestRangeI{
	/**
	*执行用时 :3 ms, 在所有 Java 提交中击败了94.49%的用户
	*内存消耗 :45.1 MB, 在所有 Java 提交中击败了62.93%的用户
	*/
	public int smallestRangeI(int[] A, int K) {
		if(A.length == 0){
			return 0;
		}
        int MIN = A[0];
		int MAX = A[0];
		for(int a : A){
			if(a > MAX){
				MAX = a;
			}
			if(a < MIN){
				MIN = a;
			}
		}
		int result = (MAX - MIN) - K * 2;
		return result > 0 ? result : 0; 
    }
}