package com.guigu.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import org.junit.Test;

/**
 * @author lxy
 * @date 2020/12/3 18:32
 **/
public class Compore {

    //排序根据首字母
    public List<Employee> compareterByAge(List<Employee> list) {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        return list;
    }
     @Test
    public void getData(){
        List<Employee> employeeList = EmployeeData.getEmployee();
        List<Employee> response = compareterByAge(employeeList);
        for(Employee data:response){
            System.out.println(data);
            System.out.println();
        }
    }

}