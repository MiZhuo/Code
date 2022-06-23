package site.mizhuo.demo2;

/**
 * @author: Mizhuo
 * @time: 2021/3/10 9:43 下午
 * @description: try-catch-finally执行顺序
 */
public class TryCatchDemo2 {
    public static void main(String[] args) {
        User user = getUser();
        System.out.println(user);
    }

    public static User getUser(){
        User user = new User();
        try {
            user.setName("张三");
            user.setAge(24);
            return user;
        }finally {
            user.setAge(18);
        }
    }

    static class User{
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
