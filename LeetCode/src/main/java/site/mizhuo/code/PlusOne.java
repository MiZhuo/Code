package site.mizhuo.code;

/**
 * Create by wulibin on 2019/6/14
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 执行用时 :1 ms, 在所有Java提交中击败了94.67%的用户
 * 内存消耗 :34.4 MB, 在所有Java提交中击败了73.27%的用户
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0;i--){
            digits[i] += 1;
            if(digits[i] > 9){
                digits[i] = 0;
            }else {
                break;
            }
        }
        if(digits[0] == 0){
            digits[0] = 1;
            int[] arrNew = new int[digits.length + 1];//定义新数组
            for(int i=0;i<digits.length;i++){
                arrNew[i] = digits[i];//把旧数组中的元素拷贝到新数组中
            }
            arrNew[arrNew.length - 1] = 0;
            return arrNew;
        }
        return digits;
    }
}
