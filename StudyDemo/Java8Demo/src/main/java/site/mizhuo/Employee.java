package site.mizhuo;

import java.util.Objects;

/**
 * @author: Mizhuo
 * @time: 2021/4/5 9:54 上午
 * @description:
 */
public class Employee{
    private String name;
    private int age;
    private double salary;
    private Status status;

    public Employee(String name, int age, double salary, Status status) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                name.equals(employee.name) &&
                status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, status);
    }

    public enum Status{
        FREE,BUSY,VOCATION
    }
}
