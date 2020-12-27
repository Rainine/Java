package 桥接模式.老师版;

/**
 * @author lxy
 * @date 2020/12/27 17:25
 **/
public class Client {

    public static void main(String[] args) {
        Brand xiaomi = new Xiaomi();
        Phone phone = new FoldPhone(xiaomi);
        phone.close();
    }
}
