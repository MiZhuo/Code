package site.mizhuo.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * 示例 1:
 *
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 *      最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 * 示例 2 :
 *
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DistributeCandies {
    /**
     * 执行用时 :77 ms, 在所有 Java 提交中击败了77.78%的用户
     * 内存消耗 :71.7 MB, 在所有 Java 提交中击败了66.35%的用户
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>(candies.length,2);
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
    /**
     * 执行用时 :164 ms, 在所有 Java 提交中击败了6.72%的用户
     * 内存消耗 :71.2 MB, 在所有 Java 提交中击败了68.93%的用户
     * @param candies
     * @return
     */
    public int distributeCandies2(int[] candies) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int c : candies){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }
        int iLoop = 0;
        int size = map.size();
        for(Integer i : map.keySet()){
            if(map.get(i) == 1){
                iLoop++;
                size --;
            }
        }
        iLoop += size;
        return iLoop > candies.length / 2 ? candies.length / 2 : iLoop;
    }
}
