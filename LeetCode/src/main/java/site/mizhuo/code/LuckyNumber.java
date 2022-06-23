package site.mizhuo.code;

/**
 *  8 is the lucky number of Xiaojiu. Xiaojiu wants to know how many numbers in the numbers 1~n contain 8.
 *  Example1
 *
 * Input:  n = 20
 * Output: 2
 * Explanation:
 * Only 8,18 contains 8.
 * Example2
 *
 * Input:  n = 100
 * Output: 19
 * Explanation:
 * 8,18,28,38,48,58,68,78,80,81,82,83,84,85,86,87,88,89,98 contains 8.
 */
public class LuckyNumber {
    /**
     * @param n: count lucky numbers from 1 ~ n
     * @return: the numbers of lucky number
     */
    public int luckyNumber(int n) {
        // Write your code here
        int iLoop = 0;
        while(n >= 1) {
            String str = String.valueOf(n--);
            if(str.contains("8")){
                iLoop++;
            }
        }
        return iLoop;
    }
}
