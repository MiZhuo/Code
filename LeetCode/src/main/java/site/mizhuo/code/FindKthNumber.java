package site.mizhuo.code;

import java.util.Arrays;

/**
 * Create by wulibin on 2019/8/2
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 例 1：
 *
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 *
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 *
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthNumber {
    /**
     * 思路分析： 这道题可能有人会想着先构造出这个乘法表，然后再去搜索，但这样是行不通的，因为m、n的取值可能非常大，非常耗内存。首先我们知道在m、n的乘法表中取值范围为[1, m * n]，那么我们可不可以使用使用二分搜索呢？
     * 首先观察乘法表我们会发现，由于构造关系，决定了他每一行都是递增的。
     *
     * 如果我们需要在第i行中寻找大于num的个数，我们只要min(num / i, n)，其中（i是这一行的行号，n是矩阵的列数）num / i代表的是如果num也在第i行，它存在的列数，所以只要取最小值就是第i行不大于num的个数。
     * （比如例题1中，我们需要知道第2行，不大于4的个数，min(4 / 2, 3) == 2个（就是2， 4））
     *
     * 那么如果我们需要确定这个乘法表中不大于num的个数就非常简单了，我们只要将每一行不大于num的个数累加即可。
     * （比如例题1中，我们需要知道乘法表中不大于4的个数，第一行3个、第二行2个，第三行1个）
     *
     * 现在我们就可以使用二分搜索了，初始化left = 1， right = n * m + 1，mid = （left + right） / 2，在m，n的乘法表中寻找不超过mid的个数。
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int m, int n, int k) {
        int low = 1,high = m * n  + 1;
        while (low < high){
            int mid = (low + high) / 2;
            int compare = compareNum(m,n,mid);
            if(compare >= k){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }

    private int compareNum(int m, int n, int mid) {
        int num = 0;
        for (int i = 1; i <= m; i++) {
            num += Math.min(mid/i, n);
        }
        return num;
    }

    /**
     * 构建乘法表，再排序取数，太占内存，速度慢
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber2(int m, int n, int k) {
        if(k > m * n){
            return -1;
        }
        int[] res = new int[m * n];
        int iLoop = 0;
        for (int i = 1; i <= m; i++) {
            for (int i1 = 1; i1 <= n; i1++) {
                res[iLoop++] = i * i1;
            }
        }
        Arrays.sort(res);
        return res[k - 1];
    }
}
