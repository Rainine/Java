package 算法题;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @author lxy
 * @date 2021/4/3 13:47
 **/
public class 找出14亿万人口每个年龄有多少人 {

    public static void main(String[] args) throws Exception {

        String str=null;
        String fileName="";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName),"UTF-8");
        long start = System.currentTimeMillis();
        final BufferedReader bufferedReader = new BufferedReader(isr);
        int total=0;
        int data[]  = new int[200];
        while ((str=bufferedReader.readLine())!=null){
            int age = Integer.valueOf(str);
            data[age]++;
            total++;
        }
        System.out.println("总共数据大小"+total);
        for (int i =0;i<200;i++){
            System.out.println(i+":" +data[i]);
        }
        System.out.println("计算时间花费:"+(System.currentTimeMillis()-start)+"ms");
    }

}
