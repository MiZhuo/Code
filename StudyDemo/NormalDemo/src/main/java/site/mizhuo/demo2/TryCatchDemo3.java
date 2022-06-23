package site.mizhuo.demo2;

/**
 * @author: Mizhuo
 * @time: 2021/3/10 9:43 下午
 * @description: try-catch-finally执行顺序
 */
public class TryCatchDemo3 {
    public static void main(String[] args) {
        System.out.println(sum(5, 8));
    }

    public static int getString(){
        int iii = 10;
        try {
            return iii;
        }catch (Exception e){

        }finally {
            iii ++;
            return 22;
        }
    }

    public static int sum(int m,int n) {
        int result = 0;
        try {
            result = n + m;
            System.out.println("try: " + result);
            return result;
        } finally {
            result = m - n;
            System.out.println("finally: " + result);
            return result;
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
