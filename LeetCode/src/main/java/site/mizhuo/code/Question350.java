package site.mizhuo.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 第350题:两个数组的交集 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 *   输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2]
 * 示例 2:
*    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9]
 * 说明:
 *   输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *   我们可以不考虑输出结果的顺序。
 * 进阶: 如果给定的数组已经排好序呢?将如何优化你的算法呢?
 * 思路:设定两个为0的指针，比较两个指针的元素是否相等。如果指针的元素相等，我们将两个指针一 起向后移动，并且将相等的元素放入空白数组。
 */
public class Question350 {
    public int[] intersect(int[] nums1,int[] nums2){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        int k = 0;
        for (int i : nums2) {
            Integer integer = map.getOrDefault(i,0);
            if(integer > 0){
                map.put(i,integer - 1);
                nums2[k] = i;
                k++;
            }
        }
        int[] res = new int[k];
        System.arraycopy(nums2,0,res,0,k);
        return res;
    }
}
