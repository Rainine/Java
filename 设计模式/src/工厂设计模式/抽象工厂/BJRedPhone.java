package 工厂设计模式.抽象工厂;

/**
 * @author lxy
 * @date 2020/12/6 13:20
 **/
/**北京生产红色手机*/
public class BJRedPhone implements  Phone{

    @Override
    public void getProduct() {
        System.out.println("进红色手机原材料");
    }

    @Override
    public void assembleProduct() {
        System.out.println(" 组装红色手机");
    }

    @Override
    public void addColor() {
        System.out.println("给红色手机上颜色");
    }

    @Override
    public void getInBox() {
        System.out.println("打包");
    }
}
