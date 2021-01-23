package 享元模式;

/**
 * @author lxy
 * @date 2021/1/23 15:30
 **/
public class ClientTest {

    public static void main(String[] args) {
        /**项目需求
         * 创建游戏中的树:
         * 特点:树的种类 是多种,同种类的树和不同种类的树的坐标相同
         * 同种类的树:被多个地方引用 ,应该共用同一个对象
         * 这里就引出两个概念:内部状态和外部状态
         * 内部状态是只稳定的状态->树的种类
         * 外部状态是不稳定的部分->树的坐标
         * */
        final TreeFactory treeFactory = new TreeFactory();

        treeFactory.getTree("杨树").growTree(new Coordinate("12","34"));
        treeFactory.getTree("杨树").growTree(new Coordinate("13","34"));
        treeFactory.getTree("柳树").growTree(new Coordinate("13","45"));
        treeFactory.getTree("桃树").growTree(new Coordinate("13","56"));
        treeFactory.getSize();
    }
}
