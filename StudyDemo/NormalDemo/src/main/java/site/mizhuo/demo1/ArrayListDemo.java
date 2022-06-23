package site.mizhuo.demo1;

import java.util.ArrayList;

/**
 * @author: Mizhuo
 * @time: 2021/3/9 7:10 下午
 * @description: 测试ArrayListDemo的交集、并集、差集
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList<Person>();
        ArrayList list2 = new ArrayList<Person>();
        Person p1 = new Person("张三", 20);
        Person p2 = new Person("李四", 18);
        Person p3 = new Person("王五", 19);
        Person p4 = new Person("赵六", 25);
        Person p5 = new Person("陈七", 24);
        list1.add(p1);
        list1.add(p2);
        list1.add(p3);
        list1.add(p5);

        list2.add(p2);
        list2.add(p3);
        list2.add(p4);
        ArrayList list3 = (ArrayList) list1.clone();
        ArrayList list4 = (ArrayList) list2.clone();
        ArrayList list5 = (ArrayList) list1.clone();
        ArrayList list6 = (ArrayList) list2.clone();
        //取交集
        list1.retainAll(list2);
        System.out.println("交集:");
        list1.forEach(System.out::println);
        //取并集
        list4.removeAll(list3);
        list3.addAll(list4);
        System.out.println("并集:");
        list3.forEach(System.out::println);
        //取差集
        list6.removeAll(list5);
        System.out.println("差集:");
        list6.forEach(System.out::println);
    }

    static class Person{
        String name;
        int age;

	    public Person(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
