package 桥接模式.老师版;

/**
 * @author lxy
 * @date 2020/12/27 17:15
 **/
public class Xiaomi implements  Brand {

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
    @Override
    public void open() {
        System.out.println("小米手机开机");
    }
    @Override
    public void close() {
        System.out.println("小米手机关机");
    }
}
