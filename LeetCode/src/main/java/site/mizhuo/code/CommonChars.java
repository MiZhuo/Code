package site.mizhuo.code;

import java.util.*;

/**
 * Create by wulibin on 2019/7/8
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CommonChars {
    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了89.54%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了94.01%的用户
     * @param A
     * @return
     */
    public List<String> commonChars(String[] A) {
        if (A.length == 0) {
            return null;
        }
        int[] arr = new int[26];
        char[] c = A[0].toCharArray();
        for (char cc : c) {
            arr[cc - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            char[] arr2 = A[i].toCharArray();
            int[] temp = new int[26];
            for (char cc : arr2) {
                temp[cc - 'a']++;
            }
            for(int j = 0; j < arr.length;j++){
                arr[j] = arr[j] > temp[j] ? temp[j] : arr[j];
            }
        }
        List<String> list = new ArrayList<>();
        for(int i =0;i < arr.length ;i++){
            int ii = arr[i];
            while (ii > 0){
                char ccc = (char) (i + 'a');
                list.add(String.valueOf(ccc));
                ii --;
            }
        }
        return list;
    }
}
