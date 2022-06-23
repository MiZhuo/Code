package site.mizhuo.code;

import java.util.*;

/**
 * @author: WuLiBin
 * @date: 2019\5\28 0028
 * @description:
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 */
public class ReorderLogFiles {
    /**
     * 执行用时 : 8 ms, 在Reorder Log Files的Java提交中击败了85.57% 的用户
     * 内存消耗 : 40.7 MB, 在Reorder Log Files的Java提交中击败了78.64% 的用户
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        for(String tmp:logs){
            for(int i=0;i<tmp.length();i++){
                if(tmp.charAt(i)==' '){
                    if(tmp.charAt(i+1)>='0'&&tmp.charAt(i+1)<='9') {
                        digits.add(tmp);
                    }else{
                        letters.add(tmp);
                    }
                    break;
                }
            }
        }
        int size = letters.size();
        letters.addAll(digits);
        String[] arr = new String[letters.size()];
        letters.toArray(arr);
        return LogSort(arr,size);
    }

    /**
     * 对字母日志进行排序,此处为冒泡排序
     * @param arr
     * @param size
     * @return
     */
    private String[] LogSort(String[] arr,int size) {
        boolean iFlag;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                iFlag = true;
                for(int ii = arr[i].indexOf(' ') + 1, jj = arr[j].indexOf(' ') + 1; ii < arr[i].length() && jj < arr[j].length();ii++,jj++){
                    if(arr[i].charAt(ii) > arr[j].charAt(jj)){
                        String temp = "";
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        iFlag = false;
                        break;
                    }else if (arr[i].charAt(ii) == arr[j].charAt(jj)){
                        continue;
                    }else{
                        iFlag = false;
                        break;
                    }
                }
                if(iFlag){
                    for(int ii = 0,jj = 0;ii < arr[i].indexOf(' ') && jj < arr[j].indexOf(' ');ii++,jj++){
                        if(arr[i].charAt(ii) > arr[j].charAt(jj)){
                            String temp = "";
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                            break;
                        }else if (arr[i].charAt(ii) == arr[j].charAt(jj)){
                            continue;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 执行用时 : 9 ms, 在Reorder Log Files的Java提交中击败了84.58% 的用户
     * 内存消耗 : 41.9 MB, 在Reorder Log Files的Java提交中击败了74.76% 的用户
     * 此方法采用重写Collections的sort方法来排序
     * @param logs
     * @return
     */
    public String[] reorderLogFiles2(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        for(String tmp:logs){
            for(int i=0;i<tmp.length();i++){
                if(tmp.charAt(i)==' '){
                    if(tmp.charAt(i+1)>='0'&&tmp.charAt(i+1)<='9') {
                        digits.add(tmp);
                    }else{
                        letters.add(tmp);
                    }
                    break;
                }
            }
        }
        Collections.sort(letters,new Comparator<String>(){
            @Override
            public int compare(String t1, String t2){
                int i = 1,j = 1;
                for(;i < t1.length();i++) {
                    if (t1.charAt(i - 1) == ' '){
                        break;
                    }
                }
                for(;j < t2.length();j++){
                    if(t2.charAt(j-1)==' ') {
                        break;
                    }
                }
                int t = (t1.substring(i)).compareTo(t2.substring(j));
                if(t == 0){
                    return (t1.substring(0,i-1).compareTo(t2.substring(0,j-1)));
                }
                return t;
            }
        });
        String res[]=new String[logs.length];
        int i = 0;
        for(String str:letters) {
            res[i++] = str;
        }
        for(String str:digits) {
            res[i++] = str;
        }
        return res;
    }
}
