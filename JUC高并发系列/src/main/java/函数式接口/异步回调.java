package 函数式接口;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import jdk.nashorn.internal.ir.CallNode.EvalArgs;

/**
 * @author lxy
 * @date 2021/3/28 13:33
 **/
public class 异步回调 {

}

class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * @Param 异步回调
         * */
        final CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "无返回值 update mysql ok");
        });
        completableFuture.get();

        System.out.println("**************************************************");
        final CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "test2");
            int a = 12 / 0;//异常点
            return 1024;
        });
        System.out.println(completableFuture2.whenComplete((t, u) -> {
            System.out.println("t:" + t);//无异常返回
            System.out.println("u:" + u);//有异常返回
        }).exceptionally(f -> {
            System.out.println(f.getMessage());
            return 404;//有异常返回
        }).get());
    }

}

