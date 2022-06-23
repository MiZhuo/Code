package site.mizhuo.code;


/**
 * @author: wulibin
 * @description:
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class MinDepth {
    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left,right) + 1;
    }
    //[1,2]
    // 必须有叶子结点，因此长度不会为1
    /*
    private int iLoop = 1;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return hasNext(root,iLoop);
    }
    public int hasNext(TreeNode node,int iLoop){
        if(node.left == null && node.right == null){
            return iLoop;
        }else if(node.right != null && node.left != null){
            iLoop ++;
            return hasNext(node.left,iLoop) > hasNext(node.right,iLoop) ? hasNext(node.right,iLoop) :  hasNext(node.left,iLoop);
        }else{
            return ++iLoop;
        }
    }
    */
}
