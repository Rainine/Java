package 建造者模式.盖房子;

/**
 * @author lxy
 * @date 2020/12/12 14:09
 **/
public class HeightHouse implements InterfaceBuilder {

    private House house = new House();

    @Override
    public void buildBasic() {
        System.out.println("建造高楼地基");

    }

    @Override
    public void buildWall() {
        System.out.println("建造高楼墙面");
    }

    @Override
    public void buildRoof() {
        System.out.println("建造高楼屋顶");
    }

    @Override
    public House builder() {
        return house;
    }
}
