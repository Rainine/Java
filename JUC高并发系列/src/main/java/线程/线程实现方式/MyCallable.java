package 线程.线程实现方式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lxy
 * @date 2021/3/7 11:15
 **/
public class MyCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final FutureTask<Integer> futureTask = new FutureTask(new MyThread());
        new Thread(futureTask, "A").start();//只会打印一次: 首先都是同一个对象,java 内部有缓存机制
        // 调用和原来一样就不去调用
        new Thread(futureTask, "B").start();
        System.out.println("main 线程 ");
        Integer o = futureTask.get();  //get一般放在最后 防止线程阻塞
        System.out.println(o);
    }

}

class MyThread implements Callable<Integer> {

    /**
     * 线程实现得第三种方式 实现 Callable 接口 1.有返回值 2.可以抛异常 3.实现 call() 方式
     */

    @Override
    public Integer call() throws Exception {
        System.out.println("*****************线程实现方式三*****************");
        return 1233;
    }
}

