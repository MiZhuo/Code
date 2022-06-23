package site.mizhuo.streamDemo;

import org.junit.Test;
import site.mizhuo.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Mizhuo
 * @time: 2021/4/5 3:29 下午
 * @description:
 */
public class StreamDemo {

    List<Employee> emps = Arrays.asList(
            new Employee("张三",18,333.33, Employee.Status.FREE),
            new Employee("李四",20,444.44, Employee.Status.BUSY),
            new Employee("王五",21,555.55, Employee.Status.FREE),
            new Employee("赵六",22,666.66, Employee.Status.FREE),
            new Employee("陈七",23,777.77, Employee.Status.BUSY),
            new Employee("杨八",24,888.88, Employee.Status.VOCATION),
            new Employee("杨八",24,888.88, Employee.Status.VOCATION),
            new Employee("杨八",24,888.88, Employee.Status.VOCATION)
    );

    /**
     * 流的创建
     */
    @Test
    public void test1() {
        //通过Collection集合提供的stream() 或 parallelStream();
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.parallelStream();
        //通过Arrays提供的静态方法stream()获取流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);
        //通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
        //创建无限流-迭代
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);
        stream4.limit(10).forEach(System.out::println);
        //创建无限流-生成
        Stream<Double> stream5 = Stream.generate(Math::random);
        stream5.limit(5).forEach(System.out::println);
    }

    /**
     * 筛选和切片
     * filter - 过滤元素
     * limit - 限制元素
     * skip - 跳过元素
     * distinct - 去重元素,通过hashCode()方法和equals()去重
     */
    @Test
    public void test2(){
        emps.stream()
                .filter(e -> e.getAge() > 20)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("-----------------------------");
        emps.stream()
                .filter(e -> e.getAge() > 20)
                .skip(2)
                .forEach(System.out::println);
        System.out.println("-----------------------------");
        emps.stream()
                .filter(e -> e.getAge() > 20)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 映射
     * map
     * flatmap
     * map 和 flatMap的区别相当于 add 和 addAll 的区别
     */
    @Test
    public void test3(){
        List<String> list = Arrays.asList("aaa","bbb","ccc");
        list.stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
        System.out.println("-----------------------------");
        emps.stream()
                .map(Employee::getName)
                .distinct()
                .forEach(System.out::println);
        System.out.println("-----------------------------");
        Stream<Stream<Character>> stream = list.stream()
                .map(StreamDemo::filterCharacter);
        stream.forEach(sm -> sm.forEach(System.out::println));
        System.out.println("-----------------------------");
        Stream<Character> stream2 = list.stream()
                .flatMap(StreamDemo::filterCharacter);
        stream2.forEach(System.out::println);
    }

    /**
     * 将字符串提取为字符流
     * @param str
     * @return
     */
    public static Stream<Character> filterCharacter(String str){
        List<Character> res = new ArrayList<>();
        for (char c : str.toCharArray()) {
            res.add(c);
        }
        return res.stream();
    }

    /**
     * 排序
     * sorted() 自然排序
     * sorted(Comparator com) 自定义排序
     */
    @Test
    public void test4(){
        List<String> list = Arrays.asList("ccc","bbb","aaa","ddd","eee");
        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("-----------------------------");
        emps.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);
    }

    /**
     * 查找与匹配
     * allMatch 检查是否匹配所有元素
     * anyMatch 检查是否至少匹配一个元素
     * noneMatch 检查是否全部不匹配
     * findFirst 返回第一个元素
     * findAny 返回流中任意元素
     * count 返回总个数
     * max 返回最大值
     * min 返回最小值
     */
    @Test
    public void test5(){
        boolean match = emps.stream()
                .allMatch(e -> e.getStatus().equals(Employee.Status.FREE));
        System.out.println(match);
        System.out.println("-----------------------------");
        boolean anyMatch = emps.stream()
                .anyMatch(e -> e.getStatus().equals(Employee.Status.FREE));
        System.out.println(anyMatch);
        System.out.println("-----------------------------");
        boolean noneMatch = emps.stream()
                .noneMatch(e -> e.getStatus().equals(Employee.Status.FREE));
        System.out.println(noneMatch);
        System.out.println("-----------------------------");
        Employee emp1 = emps.stream()
                .filter(e -> e.getStatus().equals(Employee.Status.FREE))
                .findFirst()
                .get();
        System.out.println(emp1);
        System.out.println("-----------------------------");
        Employee emp2 = emps.parallelStream()
                .filter(e -> e.getStatus().equals(Employee.Status.BUSY))
                .findAny()
                .get();
        System.out.println(emp2);
        System.out.println("-----------------------------");
        long count = emps.stream()
                .filter(e -> e.getStatus().equals(Employee.Status.BUSY))
                .count();
        System.out.println(count);
        System.out.println("-----------------------------");
        Double salary = emps.stream()
                .map(Employee::getSalary)
                .max(Double::compare)
                .get();
        System.out.println(salary);
        System.out.println("-----------------------------");
        Employee emp4 = emps.stream()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .get();
        System.out.println(emp4);
    }

    /**
     * 归约
     * reduce 将流中元素结合起来，得到一个值
     */
    @Test
    public void test6(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream()
                .reduce(0,(x,y) -> x + y);
        System.out.println(sum);
        System.out.println("-----------------------------");
        Double amount = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum)
                .get();
        System.out.println(amount);
    }

    /**
     * 收集
     * collect
     */
    @Test
    public void test7(){
        emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("-----------------------------");
        emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("-----------------------------");
        emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedList::new))
                .forEach(System.out::println);
        System.out.println("-----------------------------");
        Long count = emps.stream()
                .filter(e -> e.getStatus().equals(Employee.Status.FREE))
                .collect(Collectors.counting());
        System.out.println(count);
        System.out.println("-----------------------------");
        Double salary = emps.stream()
                .distinct()
                .filter(e -> e.getSalary() <= 500)
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(salary);
        System.out.println("-----------------------------");
        Double sum = emps.stream()
                .distinct()
                .filter(e -> e.getSalary() >= 500)
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
    }

    /**
     * 分组
     */
    @Test
    public void test8(){
        Map<Employee.Status, List<Employee>> collect = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        collect.forEach((k,v) -> System.out.println("k:" + k + "--v:" + v));
        System.out.println("-----------------------------");
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
                    if (e.getAge() >= 20) {
                        return "yong";
                    } else {
                        return "old";
                    }
                })));
        System.out.println(map);
    }

    /**
     * 分区
     */
    @Test
    public void test9(){
        Map<Boolean, List<Employee>> collect = emps.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 500));
        System.out.println(collect);
    }

    /**
     * 统计摘要
     */
    @Test
    public void test10(){
        DoubleSummaryStatistics collect = emps.stream()
                .distinct()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getMax());
        System.out.println(collect.getAverage());
        System.out.println(collect.getSum());
        System.out.println(collect.getCount());

        String str = emps.stream()
                .distinct()
                .map(Employee::getName)
                .collect(Collectors.joining("|","---","---"));
        System.out.println(str);
    }
}
