package 桥接模式.老师版;

import sun.security.rsa.RSAUtil;

/**
 * @author lxy
 * @date 2020/12/27 17:21
 **/
public class FoldPhone extends Phone {

    public FoldPhone(Brand brand) {
        super(brand);
    }
    public void call(){
        super.call();
        System.out.println("折叠手机打电话");
    }
    public void open(){
        super.open();
        System.out.println("折叠手机开机");
    }
    public void close(){
        super.close();
        System.out.println("折叠手机关机");
    }
}
