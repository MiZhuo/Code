package site.mizhuo.code;


/**
 * @author: wulibin
 * @description:
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        } else if(p.val == q.val){
            if ((p.left != null && q.left == null) || (p.left == null && q.left != null) || (p.right != null && q.right == null) || (p.right == null && q.right != null)){
                return false;
            }else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }else{
            return false;
        }
    }
}
