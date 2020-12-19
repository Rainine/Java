package 组合模式.院系;

import com.sun.org.apache.xpath.internal.operations.Or;
import 组合模式.Organize;

/**
 * @author lxy
 * @date 2020/12/19 14:48
 **/
public class Faculty implements Organize {

    private String name;
    private String des;

    public Faculty(String name,String des){
        this.name = name;
        this.des = des;
    }
    /**院系已经是最下一层级别,所以没有要添加的东西了
     *
     * */

    @Override
    public void print() {
        System.out.println("            "+name+"-"+des+"");
    }
}
