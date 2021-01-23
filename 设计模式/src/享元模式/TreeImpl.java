package 享元模式;

/**
 * @author lxy
 * @date 2021/1/23 15:23
 **/
public class TreeImpl extends AbstractTree {

    private String type;

    public TreeImpl(String type) {
        this.type = type;
    }

    @Override
    public void growTree(Coordinate coordinate) {
        System.out.println("种点"+type+"树,"+"坐标为("+coordinate.getX()+","+coordinate.getY()+")");
    }
}
