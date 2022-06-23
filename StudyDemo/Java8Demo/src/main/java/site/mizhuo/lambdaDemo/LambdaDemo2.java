package site.mizhuo.lambdaDemo;

import org.junit.Test;
import site.mizhuo.Employee;

import java.util.*;

/**
 * @author: Mizhuo
 * @time: 2021/4/5 9:53 上午
 * @description:
 */
public class LambdaDemo2 {

    @Test
    public void test1(){
        List<Employee> emps = Arrays.asList(
            new Employee("张三",18,333.33, Employee.Status.FREE),
            new Employee("李四",20,444.44, Employee.Status.BUSY),
            new Employee("王五",21,555.55, Employee.Status.FREE),
            new Employee("赵六",22,666.66, Employee.Status.FREE),
            new Employee("陈七",23,777.77, Employee.Status.BUSY),
            new Employee("杨八",24,888.88, Employee.Status.VOCATION)
        );

        Collections.sort(emps, (e1,e2) -> e1.getAge() == e2.getAge() ? e1.getName().compareTo(e2.getName()) : Integer.compare(e1.getAge(),e2.getAge()));

        emps.forEach(System.out::println);
    }

    @FunctionalInterface
    interface MyInter{
        String getValue(String str);
    }

    @Test
    public void test2(){
        MyInter myInter = str -> str.toUpperCase();
        System.out.println(myInter.getValue("wulibinaichenmiaomiao"));
    }

    @FunctionalInterface
    interface MyInter2<T,R>{
         R function(T t,T t2);
    }

    @Test
    public void test3(){
        MyInter2<Long,Long> myInter2 = (x,y) -> x + y;
        System.out.println(myInter2.function(100L,200L));
        MyInter2<Long,Long> myInter3 = (x,y) -> x * y;
        System.out.println(myInter3.function(100L,200L));
    }
}
