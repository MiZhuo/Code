package site.mizhuo.code;

/**
 * @author: Mizhuo
 * @time: 2020/4/21 4:45 下午
 * @description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = prices[i] - min > max ? prices[i] - min : max;
            }
        }
        return max;
    }

    /**
     * 动态规划
     */
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[][] dep = new int[prices.length][2];
        //考虑初始值
        dep[0][0] = 0;
        dep[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dep[i][0] = Math.max(dep[i - 1][0], dep[i - 1][1] + prices[i]);
            dep[i][1] = Math.max(dep[i - 1][1], -prices[i]);
        }
        return dep[prices.length - 1][0];
    }
}
