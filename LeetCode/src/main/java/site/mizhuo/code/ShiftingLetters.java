package site.mizhuo.code;

/**
 * 有一个由小写字母组成的字符串 S，和一个整数数组 shifts。
 *
 * 我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。
 *
 * 例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。
 *
 * 对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。
 *
 * 返回将所有这些移位都应用到 S 后最终得到的字符串。
 *
 * 示例：
 *
 * 输入：S = "abc", shifts = [3,5,9]
 * 输出："rpl"
 * 解释：
 * 我们以 "abc" 开始。
 * 将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
 * 再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
 * 最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shifting-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShiftingLetters {

    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了90.98%的用户
     * 内存消耗 :50.5 MB, 在所有 Java 提交中击败了66.67%的用户
     * @param S
     * @param shifts
     * @return
     */
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i+1] % 26;
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((chars[i] - 'a' + shifts[i]) % 26 + 'a');
        }
        return String.valueOf(chars);
    }

    /**
     * 执行用时 :13 ms, 在所有 Java 提交中击败了37.70%的用户
     * 内存消耗 :50.3 MB, 在所有 Java 提交中击败了66.67%的用户
     * @param S
     * @param shifts
     * @return
     */
    public String shiftingLetters2(String S, int[] shifts) {
        int sum = 0;
        for (int i = shifts.length - 1; i > -1; i--) {
            int temp = shifts[i] % 26;
            sum += temp;
            shifts[i] = sum % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(shifts.length > i) {
                char c = (char) (('z' - S.charAt(i)) > shifts[i] ? S.charAt(i) + shifts[i] : (('z' - S.charAt(i)) == shifts[i] ? 'z' : S.charAt(i) - (26 - shifts[i])));
                sb.append(c);
            }else{
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }


}
