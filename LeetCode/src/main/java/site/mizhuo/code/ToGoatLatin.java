package site.mizhuo.code;

/**
 * @author MiZhuo
 * @Description:
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 *
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *
 * 山羊拉丁文的规则如下：
 *
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 *
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 *
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子。
 *
 * 示例 1:
 *
 * 输入: "I speak Goat Latin"
 * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 示例 2:
 *
 * 输入: "The quick brown fox jumped over the lazy dog"
 * 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/goat-latin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-08-03 12:14
 */
public class ToGoatLatin {
    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了92.84%的用户
     * 内存消耗 :35.8 MB, 在所有 Java 提交中击败了94.80%的用户
     * @param S
     * @return
     */
    public String toGoatLatin(String S) {
        final String MA = "ma";
        String[] arr = S.split(" ");
        StringBuilder sb = new StringBuilder("a");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i].charAt(0);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                res.append(arr[i]).append(MA).append(sb).append(" ");
                sb.append("a");
            }else{
                res.append(arr[i].substring(1,arr[i].length())).append(c).append(MA).append(sb).append(" ");
                sb.append("a");
            }
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }
}
