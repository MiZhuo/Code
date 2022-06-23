package site.mizhuo.code;

import java.util.Stack;

/**
 * Create by wulibin on 2019/6/2
 * @description
 * You're now a baseball game point recorder.
 *
 * Given a list of strings, each string can be one of the 4 following types:
 *
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 *
 * You need to return the sum of the points you could get in all the rounds.
 *
 * Example 1:
 * Input: ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.
 * Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 * Example 2:
 * Input: ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get -2 points. The sum is: 3.
 * Round 3: You could get 4 points. The sum is: 7.
 * Operation 1: The round 3's data is invalid. The sum is: 3.
 * Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
 * Round 5: You could get 9 points. The sum is: 8.
 * Round 6: You could get -4 + 9 = 5 points. The sum is 13.
 * Round 7: You could get 9 + 5 = 14 points. The sum is 27.
 * Note:
 * The size of the input list will be between 1 and 1000.
 * Every integer represented in the list will be between -30000 and 30000.
 */
public class CalPoints {
    /**
     * 执行用时 : 10 ms, 在Baseball Game的Java提交中击败了42.45% 的用户
     * 内存消耗 : 34.6 MB, 在Baseball Game的Java提交中击败了90.24% 的用户
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String str : ops){
            if(str.equals("+")){
                stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
            }else if(str.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(str.equals("C")){
                stack.pop();
            }else {
                stack.push(Integer.valueOf(str));
            }
        }
        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }

    /**
     * 执行用时 : 5 ms, 在Baseball Game的Java提交中击败了90.22% 的用户
     * 内存消耗 : 34.9 MB, 在Baseball Game的Java提交中击败了82.87% 的用户
     * @param ops
     * @return
     */
    public int calPoints2(String[] ops) {
        int[] arr = new int[ops.length];
        int i = 0;
        for (String s : ops) {
            switch (s) {
                case "+":
                    arr[i] = arr[i - 1] + arr[i - 2];
                    i++;
                    break;
                case "D":
                    arr[i] = 2 * arr[i - 1];
                    i++;
                    break;
                case "C":
                    arr[i - 1] = 0;
                    i--;
                    break;
                default:
                    arr[i] = Integer.valueOf(s);
                    i++;
            }
        }
        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
        }
        return sum;
    }
}
