package site.mizhuo.code;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    private List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new LinkedList<>();
        dfs(root,"");
        return result;
    }

    public void dfs(TreeNode root,String str){
        if(root == null){
            return;
        }
        str += root.val;
        if(root.left != null) {
            dfs(root.left, str + "->");
        }
        if(root.right!=null) {
            dfs(root.right, str + "->");
        }
        if(root.left==null&&root.right==null) {
            result.add(str);
        }
    }
}
