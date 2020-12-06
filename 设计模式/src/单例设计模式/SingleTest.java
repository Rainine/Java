package 单例设计模式;

import com.sun.org.apache.bcel.internal.generic.FieldOrMethod;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.omg.CORBA.Current;

/**
 * @author lxy
 * @date 2020/12/5 11:19
 **/
public class SingleTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("----------方式一饿汉式:线程安全---------------");
        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student1 = FirstSingle.getStu();
                System.out.println("方式一" + student1.hashCode());//793922417
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student2 = FirstSingle.getStu();
                System.out.println("方式一" + student2.hashCode());//793922417
            }
        }.start();

        System.out.println("----------方式二懒汉式:线程不安全---------------");
        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student1 = SecondSingle.getStudent();
                System.out.println("方式二" + student1.hashCode());//1521612351
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student2 = SecondSingle.getStudent();
                System.out.println("方式二" + student2.hashCode());//428999437
            }
        }.start();

        System.out.println("----------方式三懒汉式+方法上+锁:线程安全---------------");
        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student1 = ThreeSingle.getStudent();
                System.out.println("方式三" + student1.hashCode());//1873649679
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student2 = ThreeSingle.getStudent();
                System.out.println("方式三" + student2.hashCode());//1873649679
            }
        }.start();

        System.out.println("----------方式四匿名内部类:线程安全---------------");
        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student1 = FourSingle.getStu();
                System.out.println("方式四" + student1.hashCode());//880702409
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student2 = FourSingle.getStu();
                System.out.println("方式四" + student2.hashCode());//880702409
            }
        }.start();

        System.out.println("----------方式五匿双重检索:线程安全---------------");
        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student1 = FiveSingle.getStudent();
                System.out.println("方式五" + student1.hashCode());//880702409
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student2 = FiveSingle.getStudent();
                System.out.println("方式五" + student2.hashCode());//880702409
            }
        }.start();

        System.out.println("----------方式六匿双重检索:线程安全---------------");
        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student1 = SixSingle.getStudent();
                System.out.println("方式六" + student1.hashCode());//591353948
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                Student student2 = SixSingle.getStudent();
                System.out.println("方式六" + student2.hashCode());//591353948
            }
        }.start();

        System.out.println("----------方式七匿双重检索:线程安全---------------");
        new Thread() {
            @Override
            public void run() {
                super.run();
                SevenSingle sevenSingle1 = SevenSingle.getInstance();
                System.out.println("方式七" + sevenSingle1.hashCode());//498974849
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                SevenSingle sevenSingle2 = SevenSingle.getInstance();
                System.out.println("方式七" + sevenSingle2.hashCode());//498974849
            }
        }.start();

        System.out.println("----------方式8匿双重检索:线程安全---------------");
        new Thread() {
            @Override
            public void run() {
                super.run();
                Map<String, Student> sevenSingle1 = Single.getStudent();
                System.out.println("方式八" + sevenSingle1.get("student").getClass().hashCode());//1054874991
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                Map<String, Student> sevenSingle2 = Single.getStudent();
                System.out.println("方式八" + sevenSingle2.get("student").getClass().hashCode());//1054874991
            }
        }.start();


    }
}

class Student {

}

/**
 * 所有单例模式,构造器私有化,目的,不允许在外部创建对象 单例模式 1 饿汉式,类初始化时就创建该对象,因为是静态成员变量 线程安全
 */
class FirstSingle {

    private static final Student stu = new Student();

    /**
     * 构造器私有化防止在外边创建对象
     */
    private FirstSingle() {
    }

    public static Student getStu() {
        /**加延时是为了延时出现线程阻塞,让两个线程都能够进到if语句里*/
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}

/**
 * 单例模式2 懒汉式,类初始化时不创建,等调用创建它的方法是再创建该对象 该方法线程不安全,需要加锁
 */
class SecondSingle {

    private static Student stu = null;

    /**
     * 构造器私有化防止在外边创建对象
     */
    private SecondSingle() {
    }

    public static Student getStudent() {
        if (stu == null) {
            /**加延时是为了延时出现线程阻塞,让两个线程都能够进到if语句里*/
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stu = new Student();
        }
        return stu;
    }
}

/**
 * 方式三:懒汉式线程安全+方法枷锁机制
 */
class ThreeSingle {

    private static Student student;

    /**
     * 构造器私有化防止在外边创建对象
     */
    private ThreeSingle() {
    }

    public static synchronized Student getStudent() {
        if (student != null) {
            return student;
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        student = new Student();
        return student;
    }
}

/**
 * 方式四 匿名内部类 线程安全
 */
class FourSingle {

    /**
     * 匿名内部类,在这里声名该对象 使⽤类的静态内部类实现的单例模式，
     * 既保证了线程安全有保证了懒加载，同时不会因为加锁的⽅式耗费性能。
     * 这主要是因为JVM虚拟机可以保证多线程并发访问的正确性，
     * 也就是⼀个类的构造⽅法在多线程环境下可以被正确的加载。
     * 此种⽅式也是⾮常推荐使⽤的⼀种单例模式
     */
    public static class FoursSingle {

        private static Student stu = new Student();
    }

    /**
     * 构造器私有化,防止创建该对象
     */
    private FourSingle() {
    }

    /**
     * 来一个返回 Student 对象的方法
     */
    public static Student getStu() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return FoursSingle.stu;
    }
}

/**
 * 方式五: 双重检索:线程安全 双锁的⽅式是⽅法级锁的优化，减少了部分获取实例的耗时。 同时这种⽅式也满⾜了懒加载。
 */
class FiveSingle {

    private static Student student = new Student();

    private FiveSingle() {
    }

    public static Student getStudent() {
        /**第一次检索,如果非空直接返回该对象*/
        if (student != null) {
            return student;
        }
        synchronized (FiveSingle.class) {
            if (student == null) {
                student = new Student();
            }
        }
        return student;
        /**如果student 该对象为空 ,则进入下面的代码,且如果是多个线程,则其它线程都要在 synchronized 外面去等候
         *等锁内的线程执行完毕出去的时候,其他线程再进来时 student 对象也不为空了,此时其他线程无法进入if语句内部
         *此处切记:一定要把锁放在if的外面,如果将锁放在if的里边,那么锁就失去了意义
         *错误写法
         *if(student == null){
         *  synchronized (FiveSingle.class){
         *      student = new Student();
         *   }
         }*/

    }
}

/**
 * CAS算法 线程安全 「AtomicReference」
 * <p>
 * java并发库提供了很多原⼦类来⽀持并发访问的数据安全性； AtomicInteger 、 AtomicBoolean 、 AtomicLong 、 AtomicReference 。 AtomicReference
 * 可以封装引⽤⼀个V实例，⽀持并发访问如上的单例⽅式就是使⽤了这样的⼀个 特点。 使⽤CAS的好处就是不需要使⽤传统的加锁⽅式保证线程安全，⽽是依赖于CAS的忙等算法，依赖
 * 于底层硬件的实现，来保证线程安全。相对于其他锁的实现没有线程的切换和阻塞也就没有了额外 的开销，并且可以⽀持较⼤的并发性。 当然CAS也有⼀个缺点就是忙等，如果⼀直没有获取到将会处于死循环中。
 */
class SixSingle {

    private static AtomicReference<Student> stu = new AtomicReference<>();

    private SixSingle() {
    }

    public static Student getStudent() {

        Student student = stu.get();

        if (student != null) {
            return student;
        }
        /**这个方法,看字面意思应该可以猜出来
         * 先比较 stu 是否等于空 如果是空就创建该对象将对象值赋给 stu
         * 相当于
         * if(stu == null){
         *     stu = new Student();
         * }
         * */
        stu.compareAndSet(null, new Student());

        return stu.get();


    }
}

/**
 * 使用枚举类:最好的方式->可以避免反序列化的 Java反射可以通过一个class文件,将该文件加载到内存然后,new一个实例出来 前面的方式也可以通过一些手段挡住反射去创建对象
 * <p>
 * 枚举类不能被反序列化的原因是因为它没有构造方法,反序列化返回的只是这样一个值, 根据这个值来查询到它对应的对象,而这个对象正是我们通过单例创建的对象
 * <p>
 * 得出结论该方法确实是非常完美,最完美没有之一
 */
enum SevenSingle {
    SevenSingle;

    public static SevenSingle getInstance() {
        return SevenSingle;
    }
}

/**
 * 方式八 线程安全 JUC下有很多集合类的容器用来保证多线程访问线程安全
 */
class Single {

    private static Map<String, Student> student = new ConcurrentHashMap<>();

    public static Map<String, Student> getStudent() {
        if (student.get("student") != null) {
            return student;
        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        student.put("student", new Student());
        return student;
    }
}
/**
 * 虽然只是⼀个很平常的单例模式，但在各种的实现上真的可以看到java的基本功的体现，这⾥包括 了；懒汉、饿汉、线程是否安全、静态类、内部类、加锁、串⾏化等等。 在平时的开发中如果可以确保此类是全局可⽤不需要做懒加载，那么直接创建并给外部调⽤即可。
 * 但如果是很多的类，有些需要在⽤户触发⼀定的条件后(游戏关卡)才显示，那么⼀定要⽤懒加载。 线程的安全上可以按需选择。 建议在学习的过程中⼀定要加以实践，否则很难完完整整的掌握⼀整套的知识体系。例如案例中的 出现的 Effective
 * Java ⼀书也⾮常建议⼤家阅读。另外推荐下这位⼤神的 Github：https://github.com/jbloch
 *  */

/**CAS算法
 * 上面我们提到了CAS算法
 * 那么给大家讲解一下啊
 * 首先有两个线程 A和 B
 * 有个主内存,里面有个值 value = 3;
 * 线程A 和线程B 要同时操作 value = 3 ,
 * 这两个线程首先将这个 value 拷贝回自己的内存去操作,而且会有个快照值,记录现在主内存的值是 3
 * 那么线程 A 将值 改为 5 写回主内存,在写回主内存之前,先检查一下现在内存中的value是否还是 3,
 * 如过还是 3 那么就将 5 写入到主内存中,
 * 这时候,主内存中的值变成了 5
 * 线程 B 它要将 value 改成 10 ,在写入主内存前,它也会先判断一下,结果发现主内存中的值 5 了,因为他被 线程A 修改了嘛
 * 所以线程 B 必须重新读取中内存中的新值重新操作,
 * 这样的话有一种最遭的情况就是,线程 B 在往主内存中写值之前,主内存中的值永远被其他线程修改过,那么线程B就相当于一直在等待,什么也没干
 * 关于CSA算法就先讲这么多,其实这个算法还是会有问题例如ABA问题,本次就不说那么多,以后我们单独说这个CAS算法的知识点
 *
 * */
