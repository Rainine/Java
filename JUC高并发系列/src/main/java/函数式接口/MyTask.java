package 函数式接口;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author lxy
 * @date 2021/3/28 12:54
 *
 * 任务拆分
 **/
public class MyTask extends RecursiveTask<Integer> {

    private static final Integer ACCESS_VALUE = 10;

    private Integer begin;

    private Integer end;

    private int result;

    public MyTask( Integer begin,Integer end) {
        this.begin = begin;
        this.end = end;

    }

    @Override
    protected Integer compute() {
        if ((end - begin) <= ACCESS_VALUE) {
            for (int i = begin; i <= end; i++) {
                result = result+i;
            }
            return result;
        }
        else {
            int mid = (end + begin) / 2;

            MyTask myTask1 = new MyTask( begin,mid);
            MyTask myTask2 = new MyTask( mid + 1,end);
            myTask1.fork();
            myTask2.fork();
            result = myTask1.join() + myTask2.join();

        }
        return result;
    }


}
class Test{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0,10);
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(myTask);
        System.out.println(submit.get());
        forkJoinPool.shutdown();
    }
}
