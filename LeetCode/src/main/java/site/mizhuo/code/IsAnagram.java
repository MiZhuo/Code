package site.mizhuo.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author MiZhuo
 * @Description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-07-29 20:55
 */
public class IsAnagram {
    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了83.15%的用户
     * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了51.64%的用户
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
       int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] ++;
            arr[t.charAt(i) - 'a'] --;
        }
        for(int i : arr){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
