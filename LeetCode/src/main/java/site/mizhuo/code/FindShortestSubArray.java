package site.mizhuo.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 *
 */
public class FindShortestSubArray {
    //解答错误
    public int findShortestSubArray(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Map<Map<Integer,Integer>,Map<Integer, Integer>> map = new HashMap<>();
        boolean iflag = true;
        for (int i = 0; i < nums.length; i++) {
            for (Map.Entry<Map<Integer,Integer>,Map<Integer, Integer>> entry : map.entrySet()) {
                for(Map.Entry<Integer,Integer> entry1 : entry.getKey().entrySet()) {
                    if (entry1.getKey() == nums[i]) {
                        int loop = entry1.getValue();
                        Map<Integer,Integer> m = new HashMap<>();
                        for(Map.Entry<Integer,Integer> entry2 : entry.getValue().entrySet()) {
                            m.clear();
                            m.put(entry2.getKey(),i);
                        }
                        Map<Integer,Integer> mm = new HashMap<>();
                        mm.put(nums[i],loop + 1);
                        Map<Integer,Integer> mmm = new HashMap<>();
                        mmm.put(nums[i],loop);
                        map.remove(mmm);
                        map.put(mm,m);
                        iflag = false;
                    }
                }
            }
            if (iflag) {
                Map<Integer,Integer> m1 = new HashMap<>();
                Map<Integer,Integer> m2 = new HashMap<>();
                m1.put(nums[i],1);
                m2.put(i, 0);
                map.put(m1,m2);
            }
            iflag = true;
        }
        return -1;
    }

}
