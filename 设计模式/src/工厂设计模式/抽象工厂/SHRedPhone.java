package 工厂设计模式.抽象工厂;

/**
 * @author lxy
 * @date 2020/12/6 13:24
 **/
public class SHRedPhone implements Phone {

    @Override
    public void getProduct() {
        System.out.println("上海进红色原材料");
    }

    @Override
    public void assembleProduct() {
        System.out.println("上海组装原材料");
    }

    @Override
    public void addColor() {
        System.out.println("上海添加颜色");
    }

    @Override
    public void getInBox() {
        System.out.println("上海打包");
    }
}
