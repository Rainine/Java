package 线程.线程池;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @author lxy
 * @date 2021/3/7 16:24
 **/
public class FirstThread {

    public static void main(String[] args) {
        /**执行长期任务性能好,创建一个线程池
         * 一池有 N 个固定的线程,有固定线程数的线程
         * */
        ExecutorService thread1 = Executors.newFixedThreadPool(5);
        /**只有一个固定的线程
         * */
        ExecutorService thread2 = Executors.newSingleThreadExecutor();
        /**
         * 有很多短期异步任务,线程池根据需要创建新线程池
         * 但在先前构建的线程可用时将重用他们
         * 可以扩容,遇强则强
         * */
        ExecutorService thread3 = Executors.newCachedThreadPool();

        ExecutorService threadMain = new ThreadPoolExecutor(
                2,   /**核心线程数*/
                5, /**线程池最大处理任务的线程数*/
                2,    /**等待时间*/
                TimeUnit.SECONDS, /**等待时间单位*/
                new LinkedBlockingQueue<Runnable>(3),  /**设置阻塞队列 并且设置阻塞队列的大小*/
               Executors.defaultThreadFactory(),  /**创建现成的工厂*/
                new AbortPolicy()); /**拒绝策略(四种)*/


         /**四种拒绝策略:
          * 4.new AbortPolicy() : 默认,直接抛出异常RejectExecutionException() 中断
          * 2.new DiscardOldestPolicy(); 抛弃队列中等待最久的任务,然后把当前的任务加入队列中,尝试再次提交当前任务
          * 3.new DiscardPolicy(); 默默丢弃无法处理的任务,不予任何处理也不抛异常,如果允许任务丢失,这时最好的一种策略
          * 4. new CallerRunsPolicy(); 不丢弃任务,也不抛异常,将任务回退给调用者
          * */

         /**查看电脑 CPU 数
          * 配置参数时候一定不能写死
          * */
        System.out.println(Runtime.getRuntime().availableProcessors());

         /**配置线程池参数
          *  CPU 密集型 maximumPoolSize Runtime.getRuntime().availableProcessors()+1 或者 +2
          *  IO密集型
          * */
        testThread(threadMain);


    }

    private static void testThread(ExecutorService thread) {
        try {
            for (int i = 0; i < 8; i++) {
                thread.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "受理任务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //用完关闭线程池
            thread.shutdown();
        }
    }

}
