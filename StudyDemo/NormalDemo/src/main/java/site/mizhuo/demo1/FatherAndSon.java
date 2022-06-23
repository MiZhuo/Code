package site.mizhuo.demo1;

/**
 * @author: Mizhuo
 * @time: 2021/3/9 9:58 下午
 * @description: 父子类加载顺序
 */
public class FatherAndSon {
    public static void main(String[] args) {
        Father father = new Son();
        father.fun();
    }
}

class Father{
    public Father() {
        System.out.println("father构造");
    }

    {
        System.out.println("father代码块");
    }

    static {
        System.out.println("father静态代码块");
    }

    public void fun(){
        System.out.println("father方法");
    }
}

class Son extends Father{
    public Son() {
        System.out.println("son构造");
    }

    {
        System.out.println("son代码块");
    }

    static {
        System.out.println("son静态代码块");
    }

    @Override
    public void fun() {
        System.out.println("son方法");
    }
}
