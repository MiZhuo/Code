package site.mizhuo.code;

import java.util.*;

/**
 * Create by wulibin on 2019/6/16
 *
 * @describle 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */


public class FrequencySort {
    /**
     * 执行用时 :119 ms, 在所有Java提交中击败了24.69%的用户
     * 内存消耗 :37.3 MB, 在所有Java提交中击败了98.19%的用户
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        map = sortByValueAscending(map);
        for (char c : map.keySet()) {
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueAscending(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            int compare = (o1.getValue()).compareTo(o2.getValue());
            //升序:return compare;
            //降序:
            return -compare;
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public String frequencySort2(String s) {
        if (s == null || s.length() < 2)
            return s;
        StringBuilder sb = new StringBuilder();
        int cs[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            cs[(int) s.charAt(i)]++;
        }
        boolean flag = true;    //用来表示是否交换
        int start = 0;
        while (flag) {
            flag = false;
            int max = start;
            for (int i = start; i < cs.length; i++) {
                if (cs[max] < cs[i])
                    max = i;
            }
            if (cs[max] != 0) {
                int count = cs[max];
                while (count > 0) {
                    sb.append((char) max);
                    count--;
                }
                flag = true;

                int temp = cs[max];
                cs[max] = cs[start];
                cs[start] = temp;
                start++;
            }
        }
        return sb.toString();
    }
}
