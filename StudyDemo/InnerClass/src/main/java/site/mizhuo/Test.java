package site.mizhuo;

/**
 * @ClassName Test
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-11-21 16:15
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        test(10);
    }

    public static void test(final int b){
        final int a = 10;
        new Thread(()->{
            System.out.println(a);
            System.out.println(b);
        }).start();
    }
}
