package site.mizhuo.code;

/**
 * Count how many 1 in binary representation of a 32-bit integer.
 *
 * 样例
 * Example 1:
 *
 * Input: 32
 * Output: 1
 * Explanation:
 * 32(100000), return 1.
 * Example 2:
 *
 * Input: 5
 * Output: 2
 * Explanation:
 * 5(101), return 2.
 */
public class CountOnes {
    public int countOnes(int num) {
        // write your code here
        if(num == 0)
            return 0;
        int count = 1;
        while((num = (num & (num - 1))) != 0) {
            count ++;
        }
        return count;
    }
}
