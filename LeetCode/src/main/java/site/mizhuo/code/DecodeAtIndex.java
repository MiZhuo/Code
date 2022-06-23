package site.mizhuo.code;

/**
 * @author: WuLiBin
 * @date: 2019\5\20 0020
 * @description:
 * An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:
 *
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
 * Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "leet2code3", K = 10
 * Output: "o"
 * Explanation:
 * The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * Example 2:
 *
 * Input: S = "ha22", K = 5
 * Output: "h"
 * Explanation:
 * The decoded string is "hahahaha".  The 5th letter is "h".
 * Example 3:
 *
 * Input: S = "a2345678999999999999999", K = 1
 * Output: "a"
 * Explanation:
 * The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 */
public class DecodeAtIndex {
    //超出内存限制
    public String decodeAtIndex2(String S, int K) {
        char[] chars = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            int i = c - '0';
            if (i >= 0 && i <= 9) {
                String str = stringBuilder.toString();
                for (; i - 1 > 0; i--) {
                    stringBuilder.append(str);
                }
            } else {
                stringBuilder.append(c);
            }
            if ((K - 1) < stringBuilder.length()) {
                chars = stringBuilder.toString().toCharArray();
                return String.valueOf(chars[K - 1]);
            }
        }
        chars = stringBuilder.toString().toCharArray();
        return String.valueOf(chars[K - 1]);
    }
    //官方解答
    public String decodeAtIndex3(String S, int K) {
        long size = 0;
        int N = S.length();

        // Find size = length of decoded string
        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else {
                size++;
            }
        }

        for (int i = N - 1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }
            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }
        throw null;
    }

    public String decodeAtIndex(String S, int K) {
        char[] chars = S.toCharArray();
        int i = 0, j = 0;
        for (; i < K; i++, j++) {
            if (j >= chars.length) {
                j -= chars.length;
            }
            if (chars[j] == '1') {
                i--;
                continue;
            }
            int loop = chars[j] - '0';
            if (loop >= 2 && loop <= 9) {
                chars[j] -= 1;
                j = -1;
                i--;
            }
        }
        while(chars[j] == '1'){
            j++;
            if(j >= chars.length){
                j -= chars.length;
            }
        }
        return String.valueOf(chars[j]);
    }
}
