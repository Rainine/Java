package 线程.线程八锁;

import java.util.concurrent.TimeUnit;

/**0
 * @author lxy
 * @date 2021/2/27 17:41
 * 一个对象如果有多个 synchronized 方法 ,某一时刻,只要有一个线程去调用其中的一个 synchronized 方法
 * 其它线程必须等待,直到该线程执行完毕 锁被释放,其他线程才可以进入其它synchronized 方法或者该 synchronized 方法
 * synchronized 锁的并非方法,而是整个资源类 当前对象 this
 *
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {
        final Phone phone = new Phone();
        final Phone phone1 = new Phone();
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            //   phone1.sendMes();
            phone1.sayHello();
        },"B").start();
    }

}
class Phone{


  public static  synchronized  void sendMes() throws InterruptedException {
      TimeUnit.SECONDS.sleep(2);
      System.out.println("*************sendMes");

  }
  public static  synchronized  void sendEmail() throws InterruptedException {
      TimeUnit.SECONDS.sleep(4);
      System.out.println("************sendEmail");
  }
  public void sayHello(){
      System.out.println("**sayHello");
  }
}
