package site.mizhuo.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] a = new int[N][];
        List<int[]> list = new ArrayList<>();
        for(int i = 1;i < N + 1 ;i++){
            for (int j = i + 1;j < N + 1;j++){
                list.add(new int[]{i,j});
            }
        }

        return false;
    }
}
