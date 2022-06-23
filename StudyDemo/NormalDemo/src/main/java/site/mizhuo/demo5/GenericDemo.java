package site.mizhuo.demo5;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2021/4/8 2:47 下午
 * @description: 泛型Demo
 */
public class GenericDemo {

    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list1 = new ArrayList<>();
        list1.add("list1");
        System.out.println(list1.get(0));
        List<Integer> list2 = new ArrayList<>();
        list2.getClass().getMethod("add",Object.class).invoke(list2,"list2");
        System.out.println(list2.get(0));
        System.out.println(list1.getClass() == list2.getClass());
    }
}
