package site.mizhuo.code;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: WuLiBin
 * @date: 2019\5\19 0019
 * @description: Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
//执行用时 : 1 ms, 在Leaf-Similar Trees的Java提交中击败了99.39% 的用户
//内存消耗 : 34.6 MB, 在Leaf-Similar Trees的Java提交中击败了82.86% 的用户
public class LeafSimilar {
    List<Integer> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ReturnHeadTreeNode(root1, list);
        ReturnHeadTreeNode(root2, list1);
        if (list1.size() != list.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list1.get(i) != list.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void ReturnHeadTreeNode(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        ReturnHeadTreeNode(node.left, list);
        ReturnHeadTreeNode(node.right, list);
    }
}
