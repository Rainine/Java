package 建造者模式.盖房子;

/**
 * @author lxy
 * @date 2020/12/12 14:06
 **/
/**建造平方*/
public class CommonHouse implements InterfaceBuilder{
     House house = new House();

    @Override
    public CommonHouse buildBasic() {
        System.out.println("建造普通房子地基");
        house.basic = new Basic("10", "10", "10");
        return  this;//返回当前对象
    }

    @Override
    public CommonHouse buildWall() {
        System.out.println("建造普通房子的墙");
        house.wall = new Wall("White","10");
        return this;//返回当前对象
    }

    @Override
    public CommonHouse buildRoof() {
        System.out.println("建造普通房子的屋顶");
        house.roof = new Roof("red","20");
        return this;//返回当前对象
    }

    @Override
    public House builder() {
        return house;//返回建造好的产品
    }
}
