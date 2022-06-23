package site.mizhuo.demo4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Mizhuo
 * @time: 2021/3/17 10:34 下午
 * @description:
 */
public class CasDemo3 {
    public static AtomicInteger a = new AtomicInteger(1);

    public static void main(String[] args) {
        Thread main = new Thread(()->{
            System.out.println("操作线程:" + Thread.currentThread().getName() + ",初始值:" + a.get());
            try{
                int expectNum = a.get();
                int newNum = expectNum + 1;
                Thread.sleep(1000);
                boolean isSuccess = a.compareAndSet(expectNum,newNum);
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",CAS操作:" + isSuccess);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"主线程");
        Thread other = new Thread(()->{
            try {
                Thread.sleep(20);
                a.incrementAndGet();
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",[increment]:" + a.get());
                a.decrementAndGet();
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",[decrement]:" + a.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        main.start();
        other.start();
    }
}
