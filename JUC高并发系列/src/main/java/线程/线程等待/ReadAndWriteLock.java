package 线程.线程等待;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lxy
 * @date 2021/3/7 14:10
 **/
public class ReadAndWriteLock {


    public static void main(String[] args) {
        final SourceClass sourceClass = new SourceClass();
        for (int i = 0; i < 7; i++) {
            final String tem = String.valueOf(i);
            new Thread(()->{
                sourceClass.read(tem);
            },tem).start();
        }

        for (int i = 0; i < 7; i++) {
            final String tem = String.valueOf(i);
            new Thread(()->{
                sourceClass.write(tem,tem);
            },tem).start();
        }

    }

}
class SourceClass{
    /**读写锁:读写分离
     * ReadWriteLockReadWriteLock readWriteLock = new ReentrantReadWriteLock();
     * volatile :
     *      1.可以保证各线程对操作资源可见性
     *      2.可以保证禁止指令重排
     *      3.不能保证原子性
     * */
    private volatile Map<String,Object> result =new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void read(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.print(Thread.currentThread().getName()+"开始读  ");
            System.out.print(result.get(key)+" ");
            System.out.println(Thread.currentThread().getName()+"读取完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
    public void write(String key,Object object){
        readWriteLock.writeLock().lock();
        try {
            System.out.print(Thread.currentThread().getName()+"开始写入数据"+ key +" ");
            result.put(key,object);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }
}