package site.mizhuo.code;


import java.util.HashSet;
import java.util.Set;

/**
 * 输入6个长方形的边长，判断6个长方形能否构成长方体
 * 输入二维数组的第一维度长度为6，第二维度为2，分别对应长方体的长和宽
 * 输入异常数据时返回false
 */
public class IsCuboid {
    public boolean isCuboid(int[][] rectangles){
        if(rectangles.length != 6) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int[] i : rectangles){
            for (int j : i){
                set.add(j);
            }
        }
        if(set.size() > 3 || set.size() < 2)
            return false;
        return true;
    }
}
