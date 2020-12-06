package com.guigu.java;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.stream.StreamFilter;
import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Test;


/**
 * @author lxy
 * @date 2020/10/18 16:56
 * 切片
 **/
public class StreamPAITest {
    @Test
    public  void  test1(){
        List<Employee> employee = EmployeeData.getEmployee();
        Stream<Employee> stream = employee.stream();
        //filter过滤流
        stream.filter(one -> one.getSalary()>93000 ).forEach(System.out::println);
        System.out.println("*******************************************************");

        try{  //无法再次执行 limit 截断流
            stream.limit(3).forEach(System.out::println);
        }catch (Exception e){
            System.out.println("无法执行  stream.limit(3).forEach(System.out::println);");
        }
       //需要再次创建一下，只输出前三个
        System.out.println("*************************需要再次创建一下，只输出前三个***************************");
         employee.stream().limit(3).forEach(System.out::println);
        //跳过前三个
        System.out.println("***********************跳过前三个*****************************");
        employee.stream().skip(3).forEach(System.out::println);
        System.out.println("***********************帅选去重*****************************");
        //需要在自定义类中重写Hashcode和equals方法
        employee.add(new Employee("刘强东","23",23,'男'));
        employee.add(new Employee("刘强东","23",23,'男'));
        employee.add(new Employee("刘强东","23",23,'男'));
        employee.add(new Employee("刘强东","23",23,'男'));
        employee.stream().distinct().forEach(System.out::println);



        System.out.println("************************************原来的方式***************");
        List<Employee > elm = new ArrayList<>();
        for(Employee e : employee){
            if( e.getSalary()>93000){
                elm.add(e);
            }
        }
        System.out.println(elm);

    }

}
