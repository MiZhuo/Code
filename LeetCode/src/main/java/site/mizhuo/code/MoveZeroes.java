package site.mizhuo.code;

/**
 * @author: WuLiBin
 * @date: 2019\6\13 0013
 * @description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 */

/**
 * 执行用时 :1 ms, 在所有Java提交中击败了96.74%的用户
 * 内存消耗 :40.4 MB, 在所有Java提交中击败了58.60%的用户
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        //后面补0
        for(int p = i; p < nums.length; p++){
            nums[p] = 0;
        }
    }
}
