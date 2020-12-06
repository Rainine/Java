package 工厂设计模式.抽象工厂;

/**
 * @author lxy
 * @date 2020/12/6 13:16
 **/
public interface Phone {
    void getProduct();//进购原材料
    void assembleProduct();//组装
    void addColor();//给手机上色
    void getInBox();//打包


}
