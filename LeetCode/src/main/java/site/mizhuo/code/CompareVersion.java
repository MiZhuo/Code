package site.mizhuo.code;

/**
 * Create by wulibin on 2019/6/21
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 *  
 *
 * 示例 1:
 *
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 * 示例 2:
 *
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 * 示例 3:
 *
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 * 示例 4：
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 * 示例 5：
 *
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CompareVersion {
    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了68.28%的用户
     * 内存消耗 :33.7 MB, 在所有 Java 提交中击败了57.93%的用户
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxSize = v1.length > v2.length ? v1.length : v2.length;
        int vv1 = 0,vv2 = 0;
        for(int i = 0;i < maxSize;i++){
            vv1 = v1.length <= i ? 0 : Integer.parseInt(v1[i]);
            vv2 = v2.length <= i ? 0 : Integer.parseInt(v2[i]);
            if(vv1 == vv2){
                continue;
            }
            return vv1 > vv2 ? 1 : -1;
        }
        return 0;
    }
}
