package site.mizhuo.demo4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mizhuo
 * @time: 2021/3/17 9:24 下午
 * @description: casDemo
 */
public class CasDemo {
    public static int count = 0;

    public static void query() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(5);
        count ++;
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int threadSize = 100;
        CountDownLatch downLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(()->{
                try {
                    for (int j = 0;j < 10 ; j++) {
                        query();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    downLatch.countDown();
                }
            });
            thread.start();
        }
        downLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + ",耗时:" + (endTime - startTime) + ",count=" + count);
    }
}
