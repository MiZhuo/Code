package site.mizhuo.code;

/**
 * 给定字符串，判断从哪个位置开始循环，得到的字符串在字典中排序最小(a<b<c,abc<abd<bbc)
 * 例如:字符串"bac"，从位置0/1/2开始循环，分别为"bac/acb/cba"，从1位置字典排序最小
 * 异常数据返回-1
 */
public class MinLoopPosition {
    public int caclMinLoopPosition(String str){
        String[] strArr = new String[str.length()];
        String s;
        String minStr = str;
        int min = 0;
        for(int i = 0; i < str.length();i++){
            String str1 = str.substring(0,i);
            String str2 = str.substring(i,str.length());
            s = str2 + str1;
            if(s.compareTo(minStr) < 0) {
                minStr = s;
                min = i;
            }
        }
        return min;
    }
}
