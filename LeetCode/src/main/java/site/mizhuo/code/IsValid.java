package site.mizhuo.code;

import java.util.Stack;

/**
 * Create by wulibin on 2019/7/23
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {
    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了94.36%的用户
     * 内存消耗 :34.1 MB, 在所有 Java 提交中击败了87.13%的用户
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(stack.size() == 0 && (c != '(' && c != '[' && c != '{')){
                return false;
            }
            if((c == ')' && stack.get(stack.size() - 1) == '(') || (c == ']' && stack.get(stack.size() - 1) == '[') || c == '}' && stack.get(stack.size() - 1) == '{'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}
