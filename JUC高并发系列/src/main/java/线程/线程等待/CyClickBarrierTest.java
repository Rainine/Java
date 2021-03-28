package 线程.线程等待;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lxy
 * @date 2021/3/7 13:22
 **/
public class CyClickBarrierTest
{

    public static void main(String[] args) {
        /**CyclicBarrier与 CountDownLatch 区别是
         * 一个增加
         * 一个减少
         * */
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()-> System.out.println("****开始召唤神龙*****"));
        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                System.out.println("第"+Thread.currentThread().getName()+"颗龙珠已经到位");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }

}
