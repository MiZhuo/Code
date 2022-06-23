package site.mizhuo.code;

/**
 * @author: WuLiBin
 * @date: 2019\5\27 0027
 * @description:
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 *
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 * Example 1:
 *
 * Input: "()"
 * Output: 1
 * Example 2:
 *
 * Input: "(())"
 * Output: 2
 * Example 3:
 *
 * Input: "()()"
 * Output: 2
 * Example 4:
 *
 * Input: "(()(()))"
 * Output: 6
 */
public class ScoreOfParentheses {
    /**执行用时 : 1 ms, 在Score of Parentheses的Java提交中击败了100.00% 的用户
    内存消耗 : 33.7 MB, 在Score of Parentheses的Java提交中击败了90.91% 的用户*/
    public int scoreOfParentheses(String S) {
        int leftCount = 0,rightCount = 0,sum = 0;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '('){
                leftCount ++;
            }else{
                rightCount++;
                if((i + 1) >= S.length() || S.charAt(i + 1) == '('){
                    sum += (1 << (leftCount - 1));
                    leftCount -= rightCount;
                    rightCount = 0;
                }
            }
        }
        return sum;
    }
}

