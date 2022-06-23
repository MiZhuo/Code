package site.mizhuo.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WuLiBin
 * @date: 2019\5\18 0018
 * @description:
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 *
 * Example:
 * Input: 4, 14, 2
 *
 * Output: 6
 *
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case). So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 */
public class TotalHammingDistance {
    //执行用时 : 13 ms, 在Total Hamming Distance的Java提交中击败了98.00% 的用户
    //内存消耗 : 39.2 MB, 在Total Hamming Distance的Java提交中击败了94.12% 的用户
    public int totalHammingDistance(int[] nums){
        int result = 0;
        int n = nums.length;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int x : nums){
                //按位取得每位上为1的个数
                count += (x >> i) & 1;
            }
            result += count * (n - count);
        }
        return result;
    }
    //超出时间限制
    public int totalHammingDistance2(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int n : nums){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0;i < 32;i++){
                stringBuilder.append(n & 1);
                n = n >>> 1;
            }
            list.add(stringBuilder.reverse().toString());
        }
        int sum = 0;
        for(int i = 0;i < list.size();i++){
            char[] c1 = list.get(i).toCharArray();
            for(int j = i + 1;j < list.size();j++){
                char[] c2 = list.get(j).toCharArray();
                for(int k = 0;k < 32;k++){
                    if(c1[k] != c2[k]){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
