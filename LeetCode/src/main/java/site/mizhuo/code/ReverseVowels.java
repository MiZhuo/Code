package site.mizhuo.code;

import java.util.*;

/**
 * @author: WuLiBin
 * @date: 2019\5\21 0021
 * @description:
 * 超出时间限制，未通过最后一个测试用例  原因： 最后return new String(chars);  不要遍历char数组。
 */
public class ReverseVowels {
    /**
     * @param ss
     * 执行用时 : 4 ms, 在Reverse Vowels of a String的Java提交中击败了98.47% 的用户
     * 内存消耗 : 35.2 MB, 在Reverse Vowels of a String的Java提交中击败了100.00% 的用户
     */
    public String reverseVowels(String ss) {
        if(ss.isEmpty()) return ss;
        char[] s = ss.toCharArray();
        int i = 0,j = s.length - 1;
        while(i < j) {
            while(i < j && !isVowel(s[i])) {
                i++;
            }
            while(i < j && !isVowel(s[j])) {
                j--;
            }
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
        return new String(s);
    }

    /**
     *
     * @param s
     * 执行用时 : 11 ms, 在Reverse Vowels of a String的Java提交中击败了51.06% 的用户
     * 内存消耗 : 41.7 MB, 在Reverse Vowels of a String的Java提交中击败了40.54% 的用户
     */
    public String reverseVowels2(String s) {
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                list.add(i);
            }
        }
        char temp;
        for (int i = list.size() - 1, j = 0; j < list.size() / 2; i--,j++) {
            temp = chars[list.get(j)];
            chars[list.get(j)] = chars[list.get(i)];
            chars[list.get(i)] = temp;
        }
        return new String(chars);
    }

    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}
