package 线程.线程等待;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lxy
 * @date 2021/3/7 15:16
 **/
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
         BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
         /**方法  抛出异常    特殊值             阻塞     超时
          * 插入   add()     offer(e)           put(e) offer(e,time,unit)
          * 移除  remove()   poll()/remove(e)   take()  poll(time,unit)
          * 检查  element()  peek()             不可用   不可用
          */

         /**
          * 注解:
          * 抛出异常:
          * 当队列满时,再往队列里add插入元素会抛出异常 Queue full
          * 当队列我为空时,remove() 移除元素抛异常 NoSuchElementException()
          */
        /**
          * 特殊值:
          * 插入方法:成功返回 true 失败返回 false
          * 移除方法:成功返回队列的元素,队列里没有就返回 null
          * /

          /**
          * 一直阻塞:
          * 当阻塞队列满时,生产者线程继续往队列里 put() 元素,队列会一直阻塞生产者线程直到put数据or 响应中断退出
          * 当阻塞队列为空时,消费者线程试图从队列里take元素,队列会一直阻塞消费者线程直到队列可用
          * /
         *
          /**
          * 超时退出:
          * 当阻塞队列满时,队列会阻塞生产者线程一定时间,超时限后生产者线程会退出
          *
          * */
        System.out.println("*************插入*****************");
        //返回值 boolean
        /**add:
         *  队列满时:抛异常
         *  队列未满时:返回true
         * */
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("a"));
        /** 异常 :Queue full -> 队列已经满了
         * */
       //blockingQueue.add("a");
        /**offer:
         *  队列满时:返回 false
         *  队列未满时:返回true
         * */
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));

        /**put:
         *  队列满时:线程阻塞不停止,一直等待
         *  队列未满时:无返回值
         * */
//        blockingQueue.put("a");
//        blockingQueue.put("a");
//        blockingQueue.put("a");

        /**put:
         *  队列满时:线程阻塞不停止,过时不候,结束时返回 false
         *  队列未满时:返回 true
         * */
//        System.out.println(blockingQueue.offer("e", 3L, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("e", 3L, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("e", 3L, TimeUnit.SECONDS));
      //  System.out.println(blockingQueue.offer("e", 3L, TimeUnit.SECONDS));

        System.out.println("*************移除****************");
        /**remove(Object o):
         * 成功返回 true
         * 失败返回 false
         * */
        blockingQueue.add("a");
        blockingQueue.remove("e");
        blockingQueue.remove("e");
        System.out.println(blockingQueue.remove("e"));
        /**remove():抛异常
         * 成功返回 对象(泛型值为 E)
         * 失败返回 NoSuchElementException
         * */

//        System.out.println(blockingQueue.remove());


    }

}
