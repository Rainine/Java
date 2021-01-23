package 享元模式;

/**
 * @author lxy
 * @date 2021/1/23 15:30
 **/
public class ClientTest {

    public static void main(String[] args) {
        final TreeFactory treeFactory = new TreeFactory();

        treeFactory.getTree("杨树").growTree(new Coordinate("12","34"));
        treeFactory.getTree("杨树").growTree(new Coordinate("13","34"));
        treeFactory.getTree("柳树").growTree(new Coordinate("13","45"));
        treeFactory.getTree("桃树").growTree(new Coordinate("13","56"));
        treeFactory.getSize();
    }
}
