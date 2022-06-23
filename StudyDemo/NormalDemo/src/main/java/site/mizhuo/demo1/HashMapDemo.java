package site.mizhuo.demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: Mizhuo
 * @time: 2021/3/9 9:39 下午
 * @description: HashMap hashcode方法和equals方法
 */
public class HashMapDemo {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("张三");
        user1.setAge(23);
        User user2 = new User();
        user2.setName("张三");
        user2.setAge(23);

        Map<User,String> map = new HashMap<>();
        map.put(user1,"user");
        map.put(user2,"user");
        System.out.println(map);
    }

    static class User{
        private String name;
        private int age;

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

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
