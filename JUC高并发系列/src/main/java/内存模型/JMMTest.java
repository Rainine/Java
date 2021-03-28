package 内存模型;

/**
 * @author lxy
 * @date 2021/2/20 22:47
 **/
public class JMMTest {

    /**
     * volatile 保证内存可见性,有序性, 不能保证原子性
     */
    private volatile static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (!flag) {

            }

            System.out.println("thread1 is over");
        });
        t1.start();

        Thread.sleep(2000);

        Thread t2 = new Thread(() -> {
            flag = true;

            System.out.println("thread2 is over");
        });
        t2.start();

    }
}
