package site.mizhuo.code;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Return a list of all uncommon words.
 * <p>
 * You may return the list in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 * <p>
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 */
public class UncommonFromSentences {
    public String[] uncommonFromSentences(String A, String B) {
        String str = A + " " + B;
        String[] arr = str.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(String s : arr){
            if(map.containsKey(s)){
                map.put(s,map.get(s) + 1);
            }else {
                map.put(s, 1);
            }
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
