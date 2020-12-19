package 组合模式.学校;


import java.util.ArrayList;
import java.util.List;
import 组合模式.Organize;

/**
 * @author lxy
 * @date 2020/12/19 14:29
 **/
public class University implements Organize {

    List<Organize> organizes = new ArrayList<>();

     private String name;
     private String des;
     public  University(String name,String des){
         this.name = name;
         this.des = des;
     }
    @Override
    public void add(Organize organize) {
         /**添加学院*/
        organizes.add(organize);
    }

    @Override
    public void remove(Organize organizeName) {
         /**删除学院从*/
       organizes.remove(organizeName);
    }
    @Override
    public void print() {
        System.out.println("*************"+name+"*****"+des+"**********");
        for (Organize organize : organizes) {
          organize.print();
        }

    }


}
