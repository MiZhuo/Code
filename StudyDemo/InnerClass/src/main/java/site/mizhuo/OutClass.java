package site.mizhuo;

/**
 * @ClassName InnerClass
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-11-21 16:05
 * @Version 1.0
 **/
public class OutClass {
    private int age = 10;
    public void outPrint(final int x) {
        class InnerClass {
            public void test(){
                System.out.println(x);
                System.out.println(age);

            }
        }
        new InnerClass().test();
    }
}
