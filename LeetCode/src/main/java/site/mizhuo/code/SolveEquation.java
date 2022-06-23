package site.mizhuo.code;

/**
 * Create by wulibin on 2019/5/26
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
 * <p>
 * If there is no solution for the equation, return "No solution".
 * <p>
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * <p>
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 * <p>
 * Example 1:
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * Example 2:
 * Input: "x=x"
 * Output: "Infinite solutions"
 * Example 3:
 * Input: "2x=x"
 * Output: "x=0"
 * Example 4:
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * Example 5:
 * Input: "x=x+2"
 * Output: "No solution"
 */
public class SolveEquation {
    public String solveEquation(String equation) {
        //根据=分成左右两个部分
        String[] eq = equation.split("=");
        String left = eq[0];
        String right = eq[1];
        int[] leftSum = sumAndX(left);
        int[] rightSum = sumAndX(right);
        if (leftSum[0] == rightSum[0]) {
            if (leftSum[1] == rightSum[1]) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + String.valueOf((rightSum[1] - leftSum[1]) / (leftSum[0] - rightSum[0]));
        }

    }

    public int[] sumAndX(String str) {
        //定义一个数组，res[0]存放x的系数，res[1]存放常数
        int[] res = new int[2];
        int isNegative = 1;
        String[] strsDe = str.split("-");
        for (int j = 0; j < strsDe.length; j++) {
            if (j != 0) isNegative = -1;
            String[] strsAe = strsDe[j].split("\\+");
            for (int i = 0; i < strsAe.length; i++) {
                if (strsAe[i].length() <= 0) continue;
                if (i != 0) isNegative = 1;
                if (strsAe[i].charAt(strsAe[i].length() - 1) == 'x') {
                    if (strsAe[i].length() > 1) {
                        res[0] += isNegative * Integer.valueOf(strsAe[i].substring(0, strsAe[i].length() - 1));
                    } else {
                        res[0] += isNegative;
                    }
                } else {
                    res[1] += isNegative * Integer.valueOf(strsAe[i]);
                }
            }
        }
        return res;
    }
}