package site.mizhuo.code;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: wulibin
 * @description:
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 *
 * Example:
 *
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 *              excluding 11,22,33,44,55,66,77,88,99
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int max = (int) Math.pow(10,n);
        int count = 0;
        for(int i = 10; i < max;i++){
            if(isSimNumber(i)){
                count ++;
            }
        }
        return max - count;
    }

    public boolean isSimNumber(int number){
        char[] chars = String.valueOf(number).toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : chars){
            set.add(c);
        }
        if(set.size() != chars.length){
            return true;
        }
        return false;
    }
    //解法2
    public int countNumbersWithUniqueDigits2(int n) {
        if(n == 0) {
            return 1;
        }
        int []dp = new int [n + 1];
        dp[0] = 1;
        dp[1] = 10;
        for(int i = 2;i <= n;i++)
        {
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - (i - 1));
        }
        return dp[n];
    }

}
