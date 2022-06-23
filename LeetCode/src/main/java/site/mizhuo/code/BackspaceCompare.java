package site.mizhuo.code;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BackspaceCompare {
    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了28.47%的用户
     * 内存消耗 :34.8 MB, 在所有 Java 提交中击败了78.05%的用户
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c == '#'){
                if(stack.size() == 0){
                    continue;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if(c == '#'){
                if(stack2.size() == 0){
                    continue;
                }
                stack2.pop();
            }else {
                stack2.push(c);
            }
        }
        return stack.equals(stack2);
    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了96.08%的用户
     * 内存消耗 :34.2 MB, 在所有 Java 提交中击败了84.82%的用户
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare2(String S, String T) {
        String s=formStringByString2(S);
        String t=formStringByString2(T);
        return s.equals(t);
    }

    private String formStringByString2(String source){
        StringBuilder builder=new StringBuilder();
        for(int i=0,length=source.length();i<length;i++){
            char temp=source.charAt(i);
            if(temp>='a'&&temp<='z'){
                builder.append(temp);
                continue;
            }
            if(temp=='#'&&builder.length()!=0){
                builder.deleteCharAt(builder.length()-1);
            }
        }
        return builder.toString();
    }
}
