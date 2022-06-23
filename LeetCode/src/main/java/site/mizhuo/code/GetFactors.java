package site.mizhuo.code;

import java.util.*;

/**
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * 样例
 * Example1
 *
 * Input: 12
 * Output:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 * Explanation:
 * 2*6 = 12
 * 2*2*3 = 12
 * 3*4 = 12
 * Example2
 *
 * Input: 32
 * Output:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 * Explanation:
 * 2*16=32
 * 2*2*8=32
 * 2*2*2*4=32
 * 2*2*2*2*2=32
 * 2*4*4=32
 * 4*8=32
 * 注意事项
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 */
public class GetFactors {
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> pids = new ArrayList<>();
        getSonFactors(pids,set,n);
        List<List<Integer>> douList = new ArrayList<>();
        for (List<Integer> list : set){
            douList.add(list);
        }
        return douList;
    }

    public void getSonFactors(List<Integer> pids, Set<List<Integer>> douList, int n){
        int des;
        boolean iflag = false;
        for (int i = 2;i < n;i++){
            if(n % i == 0){
                List<Integer> list = new ArrayList<>();
                pids.add(i);
                des = n / i;
                for(Integer p : pids) {
                    list.add(p);
                }
                list.add(des);
                Collections.sort(list);
                douList.add(list);
                getSonFactors(pids,douList,des);
            }
        }
        if(pids.size() > 0){
            pids.remove(pids.size() - 1);
        }
    }
}
