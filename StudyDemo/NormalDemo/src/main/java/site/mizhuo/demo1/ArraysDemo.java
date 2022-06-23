package site.mizhuo.demo1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2021/3/9 10:21 下午
 * @description: Arrays.asList
 */
public class ArraysDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        System.out.println(list2);
        list2.add(8);
        System.out.println(list2);
        list.add(8);
        System.out.println(list);
    }

    @Test
    public void test(){
        String[] arr = new String[]{"1","2","3"};
        List<String> list = Arrays.asList(arr);
        arr[0] = "-1";
        System.out.println(list.get(0));
    }

    @Test
    public void test2(){
        int[] arr = {1,2,3};
        List list = Arrays.asList(arr);
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
