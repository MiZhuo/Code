package site.mizhuo.code;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 */
public class Reverse {
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }
        char[] arr = String.valueOf(x).toCharArray();
        String str = "";
        for (int i = arr.length - 1;i > -1;i--){
            if(str.length() == 0 && arr[i] == '0'){
                continue;
            }
            if(arr[i] == '-'){
                str = arr[i] + str;
                break;
            }
            str += arr[i];
        }
        try {
            return Integer.valueOf(str);
        }catch (Exception e){
            return 0;
        }
    }
}
