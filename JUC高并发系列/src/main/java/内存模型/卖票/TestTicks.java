package 内存模型.卖票;

import com.sun.corba.se.impl.transport.ReaderThreadImpl;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lxy
 * @date 2021/2/27 13:42
 **/
public class TestTicks {

    public static void main(String[] args) {
        final Ticks ticks = new Ticks();

       new Thread(()->{for (int i = 0; i < 20; i++) {ticks.sale(); }},"A").start();
       new Thread(()->{for (int i = 0; i < 20; i++) {ticks.sale(); }},"B").start();
       new Thread(()->{for (int i = 0; i < 20; i++) {ticks.sale(); }},"C").start();
    }
}
class Ticks{
    private int ticks= 30;
    Lock lock =new ReentrantLock();

    public void sale(){
        lock.lock();
          try {
              if(ticks>0){
                  System.out.println(Thread.currentThread().getName()+"卖票 "+ticks--+" 还剩下"+ticks);
              }


          }catch (Exception e){
              e.printStackTrace();
          }finally {
              lock.unlock();
          }
    }
}
