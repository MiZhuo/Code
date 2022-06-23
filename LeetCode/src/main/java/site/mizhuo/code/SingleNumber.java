package site.mizhuo.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MiZhuo
 * @Description:
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-07-26 20:32
 */
public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.remove(num);
            }else {
                map.put(num, 1);
            }
        }
        int[] res = new int[map.size()];
        int iLoop = 0;
        for(int i : map.keySet()){
            res[iLoop++] = i;
        }
        return res;
    }

    public int[] singleNumber2(int[] nums) {
        //把所有的元素进行异或操作，最终得到一个异或值。该值为这两个不同的数字的异或值
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        //取异或值最后一个二进制位为1的数字作为mask，如果是1则表示两个数字在这一位上不同。
        int mask = xor & (-xor);
        //通过与这个mask进行与操作，如果为0的分为一个数组，为1的分为另一个数组。
        // 这样就把问题降低成了：“有一个数组每个数字都出现两次，有一个数字只出现了一次，求出该数字”。
        // 对这两个子问题分别进行全异或就可以得到两个解。也就是最终的数组了。
        int[] ans = new int[2];
        for (int num : nums) {
            if ( (num & mask) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
