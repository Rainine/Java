package 线程.集合线程不安全;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.junit.Test;

/**
 * @author lxy
 * @date 2021/2/27 15:16
 *问题
 * 异常 : java.util.ConcurrentModificationException 并发修改异常
 * 出现原因: 线程不安全
 * 解决:
 *    1.new Vector<>();                                  不用
 *    2.Collections.synchronizedList(new ArrayList<>())  不用
 *    3.new CopyOnWriteArrayList<>();                    用 JUC 下
 *    {  源码:
 *   public boolean add(E e) {
 *     final ReentrantLock lock = this.lock;
 *     lock.lock();
 *     try {
 *         Object[] elements = getArray();
 *         int len = elements.length;
 *         Object[] newElements = Arrays.copyOf(elements, len + 1);
 *         newElements[len] = e;
 *         setArray(newElements);
 *         return true;
 *     } finally {
 *         lock.unlock();
 *     }
 * }
 *
 * 主要是读写分离的思想:
 *    首先 在创建集合的时候底层会创建一个 object 类型数组
 *     写时复制 : 往当前容器添加数据的时候,不会往当前容器添加数据,而是将当前容器数据copy到一个 newArray
 *     并将新的容器扩容一个长度,将数据添加进去,添加完毕返回 true,之后原来的引用指向 newArray
 *     这样我们读只读取原来的容器数据
 *     写只往新的容器中写入数据
 *     是一种读写分离思想
 *    }
 **/
public class 集合线程不安全实例 {


    public static void main(String[] args) {

          testList();
      //  testSet();
       // testMap();

    }

    public static void testList() {
        List<String> data = new Vector<>();
        List<String> data1 = Collections.synchronizedList(new ArrayList<>());
        List<String> data2 = new CopyOnWriteArrayList<>();  /**写时复制*/
        List<String> data4 = new ArrayList<>();  /**写时复制*/

        for (int i = 0; i < 20; i++) {
         final int a=i;
            new Thread(() -> {

            data4.add(UUID.randomUUID().toString().substring(0, 4));
                System.out.println(data4);
                System.out.println("i="+a);
        },"线程"+i).start();

    }
}

    private static void testSet() {
        Set<String> data = new HashSet<>();
        Set<String> data1 = Collections.synchronizedSet(new HashSet<>());
        Set<String> data2 = new CopyOnWriteArraySet<>();  /**写时复制*/
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                data.add(UUID.randomUUID().toString().substring(0, 4));
                System.out.println(data);
            },"线程"+i).start();
        }
    }

    private static void testMap() {
       // Map<String,String> map = new ConcurrentHashMap<>();
        //Map<String,String> map= Collections.synchronizedMap(new HashMap<>());
        Map<String,String> map=new Hashtable<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
               map.put(UUID.randomUUID().toString().substring(0, 4),UUID.randomUUID().toString().substring(0, 4));
                System.out.println(map);
            },"线程"+i).start();
        }
   }
}
