package 工厂设计模式.抽象工厂;

/**
 * @author lxy
 * @date 2020/12/6 13:33
 **/
public class Counter {
    public Factory factory;
    public Counter(Factory factory){
        this.factory = factory;
    }
    public  Phone getPhone(String type){
        Phone phone = factory.createPhone(type);
        return phone;
    }
}
