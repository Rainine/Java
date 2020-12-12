package 建造者模式.盖房子;

/**
 * @author lxy
 * @date 2020/12/12 14:04
 **/
public interface InterfaceBuilder {

    public  void  buildBasic();
    public  void  buildWall();
    public  void  buildRoof();
    public  House builder();

}
