package 组合模式;

/**
 * @author lxy
 * @date 2020/12/19 14:30
 **/
public interface Organize {
    /**organizeName:用来打印组织名字(学校\学院\系)
     * des:对组织的描述
     * */
    public  void print();

    default  void add(Organize organize){

    }
    default  void remove(Organize organizeName){}

}
