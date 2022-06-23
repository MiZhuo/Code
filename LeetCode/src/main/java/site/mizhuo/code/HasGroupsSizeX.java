package site.mizhuo.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by wulibin on 2019/5/25
 * @description:
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * Example 2:
 *
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * Example 3:
 *
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 *
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * Example 5:
 *
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 *
 */

/**
 * 执行用时 : 27 ms, 在X of a Kind in a Deck of Cards的Java提交中击败了61.12% 的用户
 * 内存消耗 : 39.1 MB, 在X of a Kind in a Deck of Cards的Java提交中击败了91.28% 的用户
 */
public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length <= 1){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : deck){
            if(map.containsKey(i)){
                map.put(i, map.get(i).intValue() + 1);
            }else{
                map.put(i,1);
            }
        }
        int temp = map.get(deck[0]);
        for(int value : map.values()){
            temp = getCommonDivisor(temp,value);
        }
        if(temp < 2){
            return false;
        }
        return true;
    }

    /*获取最小公约数*/
    private int getCommonDivisor(int q, int p) {
        if (p == 0) {
            return q;
        }
        return getCommonDivisor(p, q % p);
    }
}
