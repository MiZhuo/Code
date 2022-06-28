package site.mizhuo.code;


/**
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 */
public class IncreasingBST {
    TreeNode treeNode = new TreeNode(0);
    public TreeNode increasingBST(TreeNode root) {
        resortTree(root);
        return null;
    }

    public void resortTree(TreeNode node){
        if(node == null){
            treeNode.left = null;
            return;
        }
        if(node.left == null){
            treeNode.val = node.val;
        }else {
            resortTree(node.left);
            if(node.right == null){
                return;
            }
            resortTree(node.right);
        }

    }
}