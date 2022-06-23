package site.mizhuo.code;

/**
 * @author: WuLiBin
 * @date: 2019\5\23 0023
 * @description: Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example 1:
 * <p>
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 * <p>
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * Example 3:
 * <p>
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 */
public class IsUgly {
    /**
     * @param num
     * @return 执行用时 : 5 ms, 在Ugly Number的Java提交中击败了90.78% 的用户
     * 内存消耗 : 32.6 MB, 在Ugly Number的Java提交中击败了79.51% 的用户
     */
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num > 1 && num <= 9) {
            return num != 7;
        } else {
            if (num % 2 == 0) {
                return isUgly(num / 2);
            }
            if (num % 3 == 0) {
                return isUgly(num / 3);
            }
            if (num % 5 == 0) {
                return isUgly(num / 5);
            }
            return false;
        }
    }

    public boolean isUgly2(int num) {
        if (num <= 0) {
            return false;
        } else if (num == 1) {
            return true;
        } else {
            while (num > 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else if (num % 3 == 0) {
                    num /= 3;
                } else if (num % 5 == 0) {
                    num /= 5;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
