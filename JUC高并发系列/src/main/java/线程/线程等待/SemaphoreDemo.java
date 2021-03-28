package 线程.线程等待;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author lxy
 * @date 2021/3/7 13:49
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {
        /**六辆车抢三个车位
         * 抢到车位的车占用资源三秒
         * 离开车位
         * 有空余车位时其它车继续抢车位
         * */
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位了");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"出去了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }
    }
}
