package 桥接模式.老师版;

/**
 * @author lxy
 * @date 2020/12/27 17:24
 **/
public class TabletPhone extends Phone {

    public TabletPhone(Brand brand) {
        super(brand);
    }
    public void open(){
        super.open();
        System.out.println("平板手机开机");

    }
    public void close(){
        super.close();
        System.out.println("平板手机关机");

    }
    public void call(){
        super.call();
        System.out.println("平板手机打电话");
    }
}
