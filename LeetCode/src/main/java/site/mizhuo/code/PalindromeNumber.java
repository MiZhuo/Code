package site.mizhuo.code;

/**
 * Check a positive number is a palindrome or not.
 *
 * A palindrome number is that if you reverse the whole number you will get exactly the same number.
 *
 * 样例
 * Example 1:
 *
 * Input:11
 * Output:true
 *
 * Example 2:
 *
 * Input:1232
 * Output:false
 * Explanation:
 * 1232!=2321
 * 注意事项
 * It's guaranteed the input number is a 32-bit integer, but after reversion, the number may exceed the 32-bit integer.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int num) {
        // write your code here
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        String temp = new String();
        for (int i = arr.length - 1; i >= 0; i--) {
            temp += arr[i];
        }
        if(str.equals(temp))
            return true;
        return false;
    }
}
