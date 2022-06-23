package site.mizhuo.code;


/**
 * @author: WuLiBin
 * @date: 2019\6\11 0011
 * @description:
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 */

/**
 * 执行用时 :
 * 1 ms, 在所有Java提交中击败了99.80%的用户
 * 内存消耗 :37.7 MB, 在所有Java提交中击败了74.76%的用户
 */
public class FindBottomLeftValue {
    int maxHeight = -1;
    int val = -1;
    public int findBottomLeftValue(TreeNode root) {
        findNode(root,0);
        return val;
    }

    public void findNode(TreeNode root,int i){
        if(root == null){
            return;
        }
        if(i > maxHeight){
            val = root.val;
            maxHeight = i;
        }
        if(root.left != null) {
            findNode(root.left, i + 1);
        }
        if(root.right != null) {
            findNode(root.right, i + 1);
        }
    }
}
