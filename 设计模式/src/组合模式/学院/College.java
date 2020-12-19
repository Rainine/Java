package 组合模式.学院;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import 组合模式.Organize;

/**
 * @author lxy
 * @date 2020/12/19 14:45
 **/
public class College implements Organize {

    List<Organize> organizes = new ArrayList<>();

    String name;
    String des;
    public College(String name,String des){
        this.name = name;
        this.des = des;
    }

    @Override
    public void add(Organize organize) {
        /**添加专业
         * */
        organizes.add(organize);
    }

    @Override
    public void remove(Organize organizeName) {
        /**删除某个专业*/
        organizes.remove(organizeName);
    }

    @Override
    public void print() {
        System.out.println("      "+name+"*****"+des+"");
        for (Organize organize : organizes) {
          organize.print();
        }


    }
}
