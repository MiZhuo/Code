package site.mizhuo.optionalDemo;

import org.junit.Test;
import site.mizhuo.Employee;

import java.util.Optional;

/**
 * @author: Mizhuo
 * @time: 2021/4/7 11:17 上午
 * @description:
 */
public class OptionalDemo {

    @Test
    public void test(){
        Employee employee = new Employee("张三", 11, 222.2, Employee.Status.BUSY);
        Employee employee2 = null;
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional.isPresent());
        optional.ifPresent(e -> System.out.println(e.getName()));
        Employee e = Optional.ofNullable(employee2).orElse(employee);
        System.out.println(e);
        Employee e2 = Optional.ofNullable(employee2).orElseGet(Employee::new);
        System.out.println(e2);
        Employee e3 = Optional.ofNullable(employee).orElseThrow(RuntimeException::new);
        System.out.println(e3);
        Optional.ofNullable(employee).map(Employee::getStatus).ifPresent(System.out::println);
        Optional.ofNullable(employee).filter(o -> o.getAge() <= 18).map(Employee::getName).map(String::toUpperCase).map(s -> s.replace("","-")).ifPresent(System.out::println);
        System.out.println("-------------");
        Optional.ofNullable(employee).flatMap(x -> Optional.of(x.getName())).ifPresent(System.out::println);
    }
}
