package site.mizhuo.demo6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2021/4/11 1:40 下午
 * @description: 迭代器删除元素Demo
 */
public class IteratorDemo {
    List<String> list = null;

    @Before
    public void before(){
        list = new ArrayList<>();
        list.add("1");
        list.add("2");
    }

    @After
    public void after(){
        list.forEach(System.out::println);
    }

    @Test
    public void test(){
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String item = it.next();
            if("2".equals(item)){
                it.remove();
            }
        }
     }

     @Test
    public void test2(){
         for (String item : list) {
             if("2".equals(item)){
                 list.remove(item);
             }
         }
     }
}
