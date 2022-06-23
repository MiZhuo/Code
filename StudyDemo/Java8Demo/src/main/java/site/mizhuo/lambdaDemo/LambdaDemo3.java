package site.mizhuo.lambdaDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: Mizhuo
 * @time: 2021/4/5 2:00 下午
 * @description:
 *
 * Java8内置四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 *      void accept(T t);
 *
 *  Supplier<T> : 供给型接口
 *      T get();
 *
 *  Function<T,R> : 函数型接口
 *      R apply(T t);
 *
 *  Predicate<T> : 断言型接口
 *      boolean test(T t);
 */
public class LambdaDemo3 {

    @Test
    public void test1(){
        consumerHandler(1000.0,d -> System.out.println("消费了" + d + "元!"));
    }

    public void consumerHandler(Double d, Consumer<Double> f){
        f.accept(d);
    }

    @Test
    public void test2(){
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(supplierHandler(() -> Math.random()));
        }
        list.forEach(System.out::println);
    }

    public Double supplierHandler(Supplier<Double> s){
        return s.get();
    }

    @Test
    public void test3(){
        String res = strHandler(" fdasfd2334fds ", str -> str.trim().toUpperCase().substring(2,5));
        System.out.println(res);
    }

    public String strHandler(String str, Function<String,String> f){
        return f.apply(str);
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList(
            "r2rfsss","s2s","fsga22f"
        );
        predicate(list,s -> s.length() > 5).forEach(System.out::println);
    }

    public List<String> predicate(List<String> list,Predicate<String> p){
        List<String> newList = new ArrayList<>();
        list.forEach(s->{
            if(p.test(s)){
                newList.add(s);
            }
        });
        return newList;
    }
}
