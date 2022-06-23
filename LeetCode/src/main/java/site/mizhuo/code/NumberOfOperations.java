package site.mizhuo.code;

/**
 * Given a string s with a-z. We want to change s into a palindrome with following operations:
 *
 * 1. change 'z' to 'y';
 * 2. change 'y' to 'x';
 * 3. change 'x' to 'w';
 * ................
 * 24. change 'c' to 'b';
 * 25. change 'b' to 'a';
 * Returns the number of operations needed to change s to a palindrome at least.
 *
 * 样例
 * Example 1:
 *
 * Input: "abc"
 * Output: 2
 * Explanation:
 *   1. Change 'c' to 'b': "abb"
 *   2. Change the last 'b' to 'a': "aba"
 * Example 2:
 *
 * Input: "abcd"
 * Output: 4
 */
public class NumberOfOperations {
    public int numberOfOperations(String s) {
        // Write your code here
        char[] arr = s.toCharArray();
        int i = 0,j = arr.length - 1,iLoop = 0;
        for (char c:arr) {
            while(i != j && (i - 1) != j){
                if(arr[i] < arr[j] ) {
                    iLoop+= (arr[j] - arr[i]);
                }
                if(arr[i] > arr[j]) {
                    iLoop+= (arr[i] - arr[j]);
                }
                i++;
                j--;
            }
        }
        return iLoop;
    }
}
