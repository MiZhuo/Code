package site.mizhuo.code;

import java.util.Arrays;

public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        // Write your code here
        char[] temp = String.valueOf(n).toCharArray();
        char s;
        int t1 = -1,t2 = -1;
        for(int j = temp.length - 1; j > -1;j--) {
            for (int i = j - 1; i > -1; i--) {
                s = temp[j];
                if (temp[i] < s) {
                    t1 = i;
                    t2 = j;
                }
            }
        }
        if(t1 != -1 && t2 != -1) {
            return Integer.valueOf(swapAndSort(temp, t1, t2));
        }else {
            return -1;
        }
    }

    private String swapAndSort(char[] chars,int i, int j) {
        chars[i] = (char) (chars[i] ^ chars[j]);
        chars[j] = (char) (chars[i] ^ chars[j]);
        chars[i] = (char) (chars[i] ^ chars[j]);
        String str1 = "";
        String str2 = "";
        for(int k = 0; k < i + 1;k ++){
            str1 += chars[k];
        }
        for(int k = i + 1; k < chars.length;k ++){
            str2 += chars[k];
        }
        char[] chars1 = str2.toCharArray();
        Arrays.sort(chars1);
        for (char c : chars1){
            str1 += c;
        }
        return str1;
    }
}
