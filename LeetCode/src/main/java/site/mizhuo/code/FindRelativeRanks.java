package site.mizhuo.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MiZhuo
 * @Description:
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-07-25 22:19
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        int order = 1;
        String ans[] = new String[nums.length];

        for (int i = nums.length - 1;i >= 0;i--) {
            int key = nums[i];
            switch(order) {
                case 1:
                    ans[map.get(key)] = "Gold Medal";
                    break;
                case 2:
                    ans[map.get(key)] = "Silver Medal";
                    break;
                case 3:
                    ans[map.get(key)] = "Bronze Medal";
                    break;
                default:
                    ans[map.get(key)] = String.valueOf(order);
            }

            order++;
        }
        return ans;
    }
}
