package 线程.线程通信;

/**
 * @author lxy
 * @date 2021/2/28 13:05
 * <p>
 * 两个线程操纵同一个变量 一个下线程让该变量增加 一个线程让该变量减一 实现交替 来十轮 变量初始值为0
 *
 * 注意问题:防止多线程虚假桓唤醒
 *  1.高内聚低耦合前提下,线程操作资源类
 *  2.三步走:判断/干活/通知
 *  3.防止虚假唤醒
 *  线程同级通信:判断一定要用 while() 不要用 if()
 *
 **/
class 交替打印 {

    public static void main(String[] args) {
        final Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    ticket.addNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    ticket.redNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    ticket.redNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    ticket.redNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "D").start();
    }

}

class Ticket {

    private int number = 0;

    public synchronized void addNumber() throws InterruptedException {
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + ":" + number);
        this.notifyAll();
    }

    public synchronized void redNumber() throws InterruptedException {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + ":" + number);
        this.notifyAll();
    }
}
