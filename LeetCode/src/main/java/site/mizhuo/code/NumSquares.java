package site.mizhuo.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WuLiBin
 * @date: 2019\5\22 0022
 * @description: Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class NumSquares {
    /**
     * @param n
     * @return 动态规划递归式
     * dp[n] = min(dp[n],dp[n-i*i]+1)     n-i*i >=0 (i=1,2,3...)
     * dp[n-i*i]+1：+1是因为i*i已经算一个组合了
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        //从0开始计算平方，直到i*i大于n，并用List记录所有1~i平方的结果
        for (int i = 0; ; i++) {
            int z = i * i;
            if (i > 1 && n % z == 0) {
                min = n / z;
            }
            if (z == n) {
                //存在一个常数的平方=n，直接返回1
                return 1;
            }
            if (z < n) {
                list.add(z);
            } else {
                break;
            }
        }
        int count = 0;
        int sum = 0;
        int index = list.size() - 1;
        while (sum != n) {
            int z = sum + list.get(index);
            if (z <= n) {
                sum = z;
                count++;
            } else {
                index--;
            }
        }
        int[] m = new int[]{Math.min(min, count)};
        getMin(list, m, n, 0, list.size() - 1, 0);
        return m[0];
    }

    //遍历所有结果，找出个数最少的方案
    private void getMin(List<Integer> list, int[] min, int n, int sum, int index, int count) {
        if (index <= 0) return;
        int z = sum + list.get(index);
        if (z <= n) {
            if (count + 1 >= min[0]) {
                return;
            }
            if (n == z) {
                if (count + 1 < min[0]) {
                    min[0] = count + 1;
                }
                return;
            }
            getMin(list, min, n, z, index, count + 1);
        }
        getMin(list, min, n, sum, index - 1, count);
    }
}
