package site.mizhuo.code;

/**
 * @author: Mizhuo
 * @time: 2020/4/21 3:04 下午
 * @description: 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divisor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DivisorGame {
    /**
     * 解：若N为基数，爱丽丝先手后N必为偶数，之后鲍勃一直选1就能胜利。
     * 若N为偶数，爱丽丝先手一直选1，最后鲍勃面临N为奇数的情况，爱丽丝获胜。
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    /**
     * 动态规划
     * 以1和2为基数
     * 若满足0 < x < N 且 N % x == 0能满足N-X为false，则N一定为true
     */
    public boolean divisorGame2(int N) {
        if (N == 1) {
            return false;
        }
        if (N == 2) {
            return true;
        }
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            dp[i] = false;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}
