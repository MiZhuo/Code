package site.mizhuo.code;

/**
 * 交换合并列表元素
 * 例如：给定的两个列表为{1,2,3}和{4,5,6,7}，函数返回列表为{1,4,2,5,3,6,7}
 * 输入异常数据时返回null
 */
public class TransAndMergElement {
    public int[] crossMerge(int[] a1,int[] a2){
        int i = 0,j = 0,k = 0;
        int[] arr = new int[a1.length + a2.length];
        while (i < (a1.length + a2.length)){
            if(i % 2 == 0){
               if(j >= a1.length && k < a2.length){
                   arr[i] = a2[k];
                   k++;
               }else {
                   arr[i] = a1[j];
                   j++;
               }
            }
            if(i % 2 != 0){
                if(k >= a2.length && j < a1.length){
                    arr[i] = a1[j];
                    j++;
                }else {
                    arr[i] = a2[k];
                    k++;
                }
            }
            i++;
        }
        return arr;
    }

}
