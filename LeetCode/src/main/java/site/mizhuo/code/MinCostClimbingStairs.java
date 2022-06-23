package site.mizhuo.code;

/**
 * Create by wulibin on 2019/7/3
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostClimbingStairs {
    /**
     * 从0或1位置开始上楼，选择跨1个台阶或者2个台阶，每个台阶对应一个体力值，选择花费体力最少到达最后的阶梯
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0 || cost.length == 1){
            return 0;
        }
        if(cost.length <= 2){
            return cost[0] < cost[1] ? cost[0] : cost[1];
        }
        int length = cost.length;
        int sum[] = new int[length];
        sum[0] = cost[0];
        sum[1] = Math.min(cost[1] + sum[0],cost[1]);
        for(int i = 2;i < length;i ++){
            sum[i] = cost[i] + Math.min(sum[i - 1],sum[i - 2]);
        }
        return Math.min(sum[length - 1],sum[length - 2]);
    }
}
