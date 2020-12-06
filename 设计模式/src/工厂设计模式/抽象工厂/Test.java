package 工厂设计模式.抽象工厂;

/**
 * @author lxy
 * @date 2020/12/6 13:36
 **/
public class Test {

    public static void main(String[] args) {
        Counter phone = new Counter( new BJFactory());
        Phone red = phone.getPhone("white");
        if(red !=null) {
            red.getProduct();/**获取手机原材料*/
            red.assembleProduct();/**组装手机*/
            red.addColor();/**给手机上颜色*/
            red.getInBox();/**给手机打包*/
        }else{
            System.out.println("对不起本店没有您想要的这款手机");
        }
    }

}
