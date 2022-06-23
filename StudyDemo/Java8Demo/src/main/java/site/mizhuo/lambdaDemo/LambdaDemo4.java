package site.mizhuo.lambdaDemo;

import org.junit.Test;
import site.mizhuo.Employee;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: Mizhuo
 * @time: 2021/4/5 2:38 下午
 * @description:
 */
public class LambdaDemo4 {

    @Test
    public void test1(){
        Consumer<String> consumer = System.out::println;
        consumer.accept("sadsa");
    }

    @Test
    public void test2(){
        Employee employee = new Employee("张三",18,222, Employee.Status.BUSY);
        Supplier<String> supplier = employee::getName;
        System.out.println(supplier.get());
    }

    @Test
    public void test3(){
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(2121, 234));
    }

    @Test
    public void test4(){
        Comparator<Integer> comparator = Integer::compareTo;
        System.out.println(comparator.compare(13123, 1312234));
    }
}
