package site.mizhuo.code;

import java.util.Arrays;

/**
 * @author MiZhuo
 * @Description:
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 *
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 *
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 *
 * 输入：[3,6,2,3]
 * 输出：8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-07-31 22:50
 */
public class LargestPerimeter {
    /**
     * 执行用时 :22 ms, 在所有 Java 提交中击败了78.48%的用户
     * 内存消耗 :49.9 MB, 在所有 Java 提交中击败了32.18%的用户
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        if(A.length < 3){
            return 0;
        }
        Arrays.sort(A);
        for (int length = A.length - 1; length > 0; length--) {
            if(length - 2 < 0){
                return 0;
            }
            if(A[length] < (A[length-1] + A[length - 2])){
                return A[length]  + A[length - 1] + A[length - 2];
            }
        }
        return 0;
    }
}