package 线程.线程等待;

import java.util.concurrent.CountDownLatch;

/**
 * @author lxy
 * @date 2021/3/7 11:53
 **/
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        /**必须等待前六个线程全部执行完毕 主线程再执行*/
        java.util.concurrent.CountDownLatch count =new java.util.concurrent.CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"离开教室");
                count.countDown();
            },String.valueOf(i)).start();
        }
        count.await();
        System.out.println("main 班长锁门");
    }
}
