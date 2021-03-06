package site.mizhuo.code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MiZhuo
 * @Description:
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-07-29 21:41
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }

    /**
     * 错误
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        int[] Larr = new int[intervals.length];
        int[] Rarr = new int[intervals.length];
        int len = 0;
        for (int i = 0,j = 0; i < intervals.length; i++,j++) {
            int left =  intervals[i][0];
            int right =  intervals[i][1];
            boolean iFlag = false;
            for (int i1 = 0; i1 < Rarr.length; i1++) {
                if(Rarr[i1] >= left){
                    Rarr[i1] = right;
                    iFlag = true;
                }
            }

            if (iFlag){
                j--;
                continue;
            }
            Larr[j] = left;
            Rarr[j] = right;
            len ++;
        }
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i][0] = Larr[i];
            res[i][1] = Rarr[i];
        }
        return res;
    }
}
