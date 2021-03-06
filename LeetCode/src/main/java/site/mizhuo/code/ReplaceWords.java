package site.mizhuo.code;

import java.util.List;

/**
 * @author MiZhuo
 * @Description:
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 * 示例 1:
 *
 * 输入: dict(词典) = ["cat", "bat", "rat"]
 * sentence(句子) = "the cattle was rattled by the battery"
 * 输出: "the cat was rat by the bat"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-07-24 22:15
 */
public class ReplaceWords {
    /**
     * 执行用时 :37 ms, 在所有 Java 提交中击败了63.89%的用户
     * 内存消耗 :45.4 MB, 在所有 Java 提交中击败了98.77%的用户
     * @param dict
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dict, String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for(String s : dict){
                if (arr[i].startsWith(s)) {
                    arr[i] = s;
                    break;
                }
            }
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
