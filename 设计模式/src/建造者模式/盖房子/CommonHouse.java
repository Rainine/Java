package 建造者模式.盖房子;

/**
 * @author lxy
 * @date 2020/12/12 14:06
 **/
public class CommonHouse implements InterfaceBuilder{
    private House house = new House();

    @Override
    public void buildBasic() {
        System.out.println("建造普通房子地基");
    }

    @Override
    public void buildWall() {

        System.out.println("建造普通房子的墙");
    }

    @Override
    public void buildRoof() {

        System.out.println("建造普通房子的屋顶");
    }

    @Override
    public House builder() {

        return house;
    }
}
