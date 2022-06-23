package site.mizhuo.demo4;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: Mizhuo
 * @time: 2021/3/17 10:34 下午
 * @description:
 */
public class CasDemo4 {
    public static AtomicStampedReference<Integer> a = new AtomicStampedReference(1,1);

    public static void main(String[] args) {
        Thread main = new Thread(()->{
            System.out.println("操作线程:" + Thread.currentThread().getName() + ",初始值:" + a.getReference());
            try{
                int expectNum = a.getReference();
                int newNum = expectNum + 1;
                int expectStamp = a.getStamp();
                int newStamp = expectStamp + 1;
                Thread.sleep(1000);
                boolean isSuccess = a.compareAndSet(expectNum,newNum,expectStamp,newStamp);
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",CAS操作:" + isSuccess);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"主线程");
        Thread other = new Thread(()-> {
            try {
                Thread.sleep(20);
                a.compareAndSet(a.getReference(),(a.getReference() + 1),a.getStamp(),(a.getStamp() + 1));
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",[increment]:" + a.getReference());
                a.compareAndSet(a.getReference(),(a.getReference() - 1),a.getStamp(),(a.getStamp() + 1));
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",[decrement]:" + a.getReference());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        main.start();
        other.start();
    }
}
