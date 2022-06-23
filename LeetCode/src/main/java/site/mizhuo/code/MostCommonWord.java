package site.mizhuo.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by wulibin on 2019/6/3
 * @description
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 *
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 */
public class MostCommonWord {
    /**
     * 执行用时 : 26 ms, 在Most Common Word的Java提交中击败了81.19% 的用户
     * 内存消耗 : 37.5 MB, 在Most Common Word的Java提交中击败了82.89% 的用户
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> map = new HashMap<>();
        String spits = ",.:!?';";
        for (char i : spits.toCharArray()) {
            paragraph = paragraph.replace(i, ' ');
        }
        paragraph = paragraph.toLowerCase();
        String[] strings = paragraph.split(" ");
        for (String str : strings) {
            if("".equals(str)){
                continue;
            }
            if(map.containsKey(str)){
                map.put(str,map.get(str) + 1);
            }else{
                map.put(str,1);
            }
        }
        for (String s : banned) {
            map.remove(s);
        }
        int temp = 0;
        String result = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > temp){
                temp = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
