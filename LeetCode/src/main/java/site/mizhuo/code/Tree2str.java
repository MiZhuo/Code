package site.mizhuo.code;

/**
 * @author: WuLiBin
 * @date: 2019\5\29 0029
 * @description: You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * <p>
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 * <p>
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * Output: "1(2(4))(3)"
 * <p>
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * Output: "1(2()(4))(3)"
 * <p>
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class Tree2str {
    /**
     * 执行用时 : 6 ms, 在Construct String from Binary Tree的Java提交中击败了85.12% 的用户
     * 内存消耗 : 39.6 MB, 在Construct String from Binary Tree的Java提交中击败了94.09% 的用户
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t != null) {
            tree(t, sb);
        }
        return sb.toString();
    }

    public void tree(TreeNode t, StringBuilder sb) {
        if (t == null) {
            return;
        }
        sb.append(t.val);
        if (t.left != null) {
            sb.append("(");
            tree(t.left, sb);
            sb.append(")");
        } else {
            if (t.right == null) {
                sb.append("()");
            }
        }
        if (t.right != null) {
            sb.append("(");
            tree(t.right, sb);
            sb.append(")");
        }
    }
}
