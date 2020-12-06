package com.guigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxy
 * @date 2020/10/18 16:14
 **/
public class EmployeeData {

    public  static List<Employee> getEmployee() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("马云", "AD", 1, '男'));
        list.add(new Employee("马化腾", "DAS", 2, '男'));
        list.add(new Employee("雷军", "AS", 3, '男'));
        list.add(new Employee("李彦宏", "BB", 4, '男'));
        list.add(new Employee("刘强东", "CV", 5, '男'));
        list.add(new Employee("柳传志", "GV", 6, '男'));
        list.add(new Employee("刘墉", "HG", 7, '男'));
        list.add(new Employee("李嘉诚", "FR", 8, '男'));
        list.add(new Employee("史玉柱", "TF", 9, '男'));
        list.add(new Employee("黄光裕", "KJ", 10, '男'));
        list.add(new Employee("张靓颖", "EF", 755647, '女'));
        return  list;
    }

}
