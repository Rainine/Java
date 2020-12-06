package com.guigu.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.Test;
import sun.awt.HKSCS;

/**
 * @author lxy
 * @date 2020/10/18 13:05
 **/
public class TestLambda {
    @Test   //lambda表达式
    public void test01(){
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("我要去大厂");
            }
        };
           run.run();
        System.out.println("**********************************************");
        Runnable run1 = () -> System.out.println("我要去京东");
        run1.run();
    }
    @Test   //lambda表达式多参数的时候且有返回值不止一个执行语句
    public  void test02(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int num = com.compare(12,32);
        System.out.println(num);
        System.out.println("*******************************************");
        Comparator<Integer> com1 = Integer::compareTo;
        int a = com1.compare(43,12);
        System.out.println(a);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        //方法引用
        Comparator<Integer> com2 = Integer::compareTo;
        int b = com2.compare(1,12);
        System.out.println(b);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Comparator<Integer> com3 = (o1,o2)-> {
            System.out.println(o1);
            System.out.println(o2);
         return    o1.compareTo(o2);

        };
        int c = com3.compare(756,12);
        System.out.println(c);
    }
    @Test// 有参数无返回值
    public void test03(){
        Consumer<String> con =new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("谎言和誓言的区别");
            }
        };
        System.out.println("**********************************************");
        Consumer<String> con1 = str-> System.out.println(str);
        con1.accept("一个是听的人新信了，一个是说的人信了");
    }
    @Test
    public void test4(){

    }
    @Test
    public void  str() {
        List<String> list = Arrays.asList("北京", "上海", "普京", "南京", "广州");
        List<String> str = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(str);
        System.out.println("********************************************");
        List<String> str1 = filterString(list, s -> s.contains("京"));
        System.out.println(str1);
    }
    //根据给定的规则校验字符串，此规则由Predicate方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> listStr = new ArrayList<>();
        for(String s : list){
            if(pre.test(s)){
                listStr.add(s);
            }
        };

        return listStr;
    }
    @Test
    public void num(){
        Function<Integer,String[]> fun1 = length -> new String[length];
        String[] arr = fun1.apply(5);
        System.out.println(Arrays.toString(arr));
        System.out.println("************************************");
        Function<Integer,String[]> fun2 = String[] :: new ;
        String[] arrs = fun1.apply(6);
        System.out.println(Arrays.toString(arrs));
    }
}
