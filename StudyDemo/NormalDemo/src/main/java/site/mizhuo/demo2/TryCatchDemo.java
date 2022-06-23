package site.mizhuo.demo2;

/**
 * @author: Mizhuo
 * @time: 2021/3/10 9:26 下午
 * @description: try-catch-finally执行顺序
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        boolean fun = fun(1);
        System.out.println(fun);
        boolean fun2 = fun(0);
        System.out.println(fun2);

    }


    private static boolean fun(int ii){
        try {
            int i = 1 / ii;
            return true;
        }catch (Exception e){
            return false;
        }finally {
            return false;
        }
    }
}
