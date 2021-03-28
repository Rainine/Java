package 线程.线程通信;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lxy
 * @date 2021/2/28 15:10
 **/
public class 精准唤醒指定线程 {

    public static void main(String[] args) {
        final PrintData printData = new PrintData();

        new Thread(() -> {
            for (int j = 0; j < 5; j++) {
                printData.print5(j);
            }
        }, "1").start();
        new Thread(() -> {
            for (int j = 0; j < 5; j++) {
                printData.print10(j);
            }
        }, "2").start();
        new Thread(() -> {
            for (int j = 0; j < 5; j++) {
                printData.print15(j);
            }
        }, "3").start();
    }
}



class PrintData {

    private int number = 1;  //标识符
    private Lock lock = new ReentrantLock(); //锁
    private Condition c1 = lock.newCondition();//钥匙
    private Condition c2 = lock.newCondition();//钥匙
    private Condition c3 = lock.newCondition();//钥匙

    public void print5(int j) {
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("AAAAA打印 " + i + "次,第" + j + "轮");
            }
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int j) {
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("BBBBB打印 " + i + "次,第" + j + "轮");
            }
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int j) {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("CCCCC打印 " + i + "次,第" + j + "轮");
            }
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
