package site.mizhuo.code;

import java.util.HashSet;
import java.util.Set;

/**
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 *
 * N  will be in range [1, 10000].
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 2; i <= N;i++){
            String str = String.valueOf(i);
            if(str.contains("3") || str.contains("4") || str.contains("7")){
                continue;
            }
            if(str.contains("2") || str.contains("5") || str.contains("6") || str.contains("9")){
                count++;
            }
        }
        return count;
    }
}
