package JVM加载验证初始化;

/**
 * @author lxy
 * @date 2021/2/20 12:44
 **/
public class TestLoad {

    public static void main(String[] args) {
        new A();
        B  b = null;
    }
}
class A {
    static {
        System.out.println("*************load class A **************");


    }
    public A(){
        System.out.println("*************initial class A **************");
    }

}

class B {
    static {
        System.out.println("*************load class B **************");


    }
    public B(){
        System.out.println("*************initial class B **************");
    }

}