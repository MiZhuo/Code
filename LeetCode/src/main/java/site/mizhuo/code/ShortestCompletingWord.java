package site.mizhuo.code;

import java.util.*;

/**
 * Create by wulibin on 2019/7/6
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
 *
 * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 *
 * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
 *
 * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 说明：最短完整词应该包括 "s"、"p"、"s" 以及 "t"。对于 "step" 它只包含一个 "s" 所以它不符合条件。同时在匹配过程中我们忽略牌照中的大小写。
 *  
 *
 * 示例 2：
 *
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 说明：存在 3 个包含字母 "s" 且有着最短长度的完整词，但我们返回最先出现的完整词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-completing-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestCompletingWord {
    /**
     * 执行用时 :64 ms, 在所有 Java 提交中击败了14.03%的用户
     * 内存消耗 :45.9 MB, 在所有 Java 提交中击败了31.35%的用户
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character,Integer> map = new HashMap<>();
        licensePlate = licensePlate.toLowerCase();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if(c <= 'z' && c >= 'a'){
                if(map.containsKey(c)){
                    map.put(c,map.get(c) + 1);
                }else {
                    map.put(c,1);
                }
            }
        }
        int length = Integer.MAX_VALUE;
        String res = "";
        for(String str : words){
            String temp = str.toLowerCase();
            Map<Character,Integer> map2 = new HashMap<>(map);
            for(int i = 0;i < temp.length();i++){
                char cc = temp.charAt(i);
                if(map2.containsKey(cc)){
                    if(map2.get(cc) > 0){
                        map2.put(cc,map2.get(cc) - 1);
                    }
                }
            }
            boolean iflag = true;
            for(int i : map2.values()){
                if(i != 0){
                    iflag = false;
                }
            }
            if(iflag) {
                if (str.length() < length) {
                    length = str.length();
                    res = str;
                }
            }
        }
        return res;
    }

    public String shortestCompletingWord2(String licensePlate, String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for(char ch : licensePlate.toLowerCase().toCharArray())
            if(ch >= 97 && ch <= 123)
                map.put(ch - 97, map.getOrDefault(ch - 97, 0) + 1);
        //对数组按长度排序
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for(String word : words){
            int[] alpha = new int[26];
            for(char ch : word.toLowerCase().toCharArray())
                if(ch >= 97 && ch <= 123)
                    alpha[ch - 97] ++;
            //对比每个字符串和licensePlate
            boolean flag = true;
            for(int key : map.keySet())
                if(alpha[key] < map.get(key)){
                    flag = false;
                    break;
                }
            if(flag) return word;
        }
        return null;
    }
}
