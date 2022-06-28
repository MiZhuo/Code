package site.mizhuo.code;
/**
 * @PackageName: LeetCode_2020_03
 * @ClassName: MergeTrees
 * @Decription:
 * @Author: MiZhuo
 * @Date: 16:49 
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null ) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
