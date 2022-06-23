package site.mizhuo.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by wulibin on 2019/6/18
 * @describle
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class MatrixReshape {

    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了93.22%的用户
     * 内存消耗 :44.5 MB, 在所有 Java 提交中击败了84.28%的用户
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int iii = 0;
        for(int[] n : nums){
            for (int i : n){
                iii++;
            }
        }
        if(iii != r * c){
            return nums;
        }
        int[][] newNums = new int[r][c];
        int loop = 0;
        int bloop = 0;
        int[] inNums = new int[c];
        for(int[] n : nums){
            for (int i : n){
                if(loop == c) {
                    loop = 0;
                    newNums[bloop++] = inNums;
                    inNums = new int[c];
                }
                inNums[loop++] = i;
            }
        }
        newNums[bloop] = inNums;
        return newNums;
    }


    /**uyi
     * 执行用时 :20 ms, 在所有 Java 提交中击败了5.45%的用户
     * 内存消耗 :49.4 MB, 在所有 Java 提交中击败了60.69%的用户
     */
    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        List<Integer> list = new ArrayList<>();
        for(int[] n : nums){
            for (int i : n){
                list.add(i);
            }
        }
        if(list.size() < r * c){
            return nums;
        }
        int[][] newNums = new int[r][c];
        for(int i = 0; i < r;i++) {
            int[] sn = new int[c];
            for (int j = 0; j < c; j++) {
                sn[j] = list.get(0);
                list.remove(0);
            }
            newNums[i] = sn;
        }
        return newNums;
    }


}
