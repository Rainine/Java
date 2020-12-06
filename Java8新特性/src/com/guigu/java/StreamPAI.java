package com.guigu.java;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;
/**
 * @author lxy
 * @date 2020/10/18 16:08
 **/
public class StreamPAI {
    //通过集合的方式创建对象
    @Test
    public  void test1(){
        List<Employee> employee = EmployeeData.getEmployee();
        //default Stream<E> stream（）
        Stream<Employee> str = employee.stream();
        //default Stream<E> parallelStream() :返回一个并行流
        Stream<Employee> par = employee.parallelStream();
    }//方式二通过数组创建对象
    @Test
    public void test2(){
        //int 型
        int [] arr = new int[]{1,2,3,4};
        IntStream stream = Arrays.stream(arr);
        //自定义类型
        Employee e1 = new Employee("Tom","12",12,'男');
        Employee e2 = new Employee("Jerry","32",1654,'女');
        Employee [] em = {e1,e2};
        Stream<Employee> stream1 = Arrays.stream(em);
    }
    //方式三
    @Test
    public void test4(){
        //通过Stream自带of()创建对象
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);
    }//方式四
    @Test
    public void test5(){
        //创建无限流
    Stream.iterate(0,t ->t+2).limit(10).forEach(System.out::println);
    Stream.generate(Math :: random).limit(10).forEach(System.out::println);
    }
}
