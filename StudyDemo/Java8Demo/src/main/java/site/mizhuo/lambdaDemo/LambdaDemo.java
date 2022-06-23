package site.mizhuo.lambdaDemo;

import org.junit.Test;
import site.mizhuo.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2021/4/4 9:12 下午
 * @description:
 */
public class LambdaDemo {
    List<Employee> emps = Arrays.asList(
        new Employee("张三",18,333.33, Employee.Status.FREE),
        new Employee("李四",20,444.44, Employee.Status.BUSY),
        new Employee("王五",21,555.55, Employee.Status.FREE),
        new Employee("赵六",22,666.66, Employee.Status.FREE),
        new Employee("陈七",23,777.77, Employee.Status.BUSY),
        new Employee("杨八",24,888.88, Employee.Status.VOCATION)
    );

    /**
     * 过滤出工资>500的员工
     * @param emps
     * @return
     */
    public List<Employee> filterEmployee(List<Employee> emps){
        List<Employee> newEmps = new ArrayList<>();
        for (Employee emp : emps) {
            if(emp.getSalary() > 500){
                newEmps.add(emp);
            }
        }
        return newEmps;
    }

    @Test
    public void test1(){
        List<Employee> employees = filterEmployee(emps);
        for(Employee emp : employees){
            System.out.println(emp);
        }
    }

    /**
     * 过滤出年龄<=20的员工
     * @param emps
     * @return
     */
    public List<Employee> filterEmployee2(List<Employee> emps){
        List<Employee> newEmps = new ArrayList<>();
        for (Employee emp : emps) {
            if(emp.getAge() <= 20){
                newEmps.add(emp);
            }
        }
        return newEmps;
    }

    @Test
    public void test2(){
        List<Employee> employees = filterEmployee2(emps);
        for(Employee emp : employees){
            System.out.println(emp);
        }
    }

    /**
     * 使用策略模式优化代码
     */
    interface EmployeeFilter<T>{
        boolean filterEmployee(Employee emp);
    }

    class FilterEmpByAge implements EmployeeFilter{
        @Override
        public boolean filterEmployee(Employee emp) {
            return emp.getAge() <= 20;
        }
    }

    public List<Employee> filterEmployee(List<Employee> employees,EmployeeFilter filter){
        List<Employee> newEmps = new ArrayList<>();
        for (Employee employee : employees) {
            if(filter.filterEmployee(employee)){
                newEmps.add(employee);
            }
        }
        return newEmps;
    }

    @Test
    public void test3(){
        List<Employee> employees = filterEmployee(emps,new FilterEmpByAge());
        for(Employee emp : employees){
            System.out.println(emp);
        }
    }

    class FilterEmpBySalary implements EmployeeFilter{
        @Override
        public boolean filterEmployee(Employee emp) {
            return emp.getSalary() > 500;
        }
    }

    @Test
    public void test4(){
        List<Employee> employees = filterEmployee(emps,new FilterEmpBySalary());
        for(Employee emp : employees){
            System.out.println(emp);
        }
    }

    /**
     * 使用匿名内部类
     */
    @Test
    public void test5(){
        List<Employee> employees = filterEmployee(emps, new EmployeeFilter() {
            @Override
            public boolean filterEmployee(Employee emp) {
                return emp.getSalary() > 500;
            }
        });
        for(Employee emp : employees){
            System.out.println(emp);
        }
    }

    /**
     * 使用lambda表达式
     */
    @Test
    public void test6(){
        List<Employee> employees = filterEmployee(emps, e -> e.getSalary() > 500);
        employees.forEach(System.out::println);
    }

    /**
     * 使用StreamApi
     */
    @Test
    public void test7(){
        emps.stream()
            .filter(e -> e.getSalary() > 500)
            .forEach(System.out::println);
    }
}



