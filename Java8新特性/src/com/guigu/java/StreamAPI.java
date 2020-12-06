package com.guigu.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author lxy
 * @date 2020/10/18 18:07
 * 映射
 **/
public class StreamAPI {
    @Test
    public  void  test1(){
//        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
//        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        //获取员工姓名长度小于3的名字
        List<Employee> employee = EmployeeData.getEmployee();
        employee.stream().filter(one -> one.getSalary() == 3).forEach(System.out::println);


//        Stream<String> namesStream = employee.stream().map(Employee::getName);
//        namesStream.filter(name -> name.length()<3).forEach(System.out::println);

    }
    @Test
    public  void  test2(){
        ArrayList list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList<>();
        list2.add(12);
        list2.add(12);
        list2.add(12);

      //  四个元素
//        list2.add(list1);
//        System.out.println(list2);
        // 六个元素
        list2.addAll(list1);
        System.out.println(list2);


    }
}
