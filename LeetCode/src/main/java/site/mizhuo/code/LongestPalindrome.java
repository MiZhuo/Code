package site.mizhuo.code;

/**
 * @author: Mizhuo
 * @time: 2020/3/30 1:33 下午
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        //动态规划
        //Step1:定义dp[l][r],如果Sl-Sr为回文子串，则dp[l][r] = true;
        //Step2:找到dp[l][r] 和 上一级的关系：dp[l][r] = dp[l+1][r-1] && Sl == Sr
        //Step3:初始化dp[l][r]，当l=r时，dp[l][r] = true
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxLength = 1;
        int maxStart = 0;
        int maxEnd = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLength) {
                        maxLength = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }

        return s.substring(maxStart, maxEnd + 1);
    }
}
