package 建造者模式.盖房子;

/**
 * @author lxy
 * @date 2020/12/12 14:09
 **/
/**建造高楼*/
public class HeightHouse implements InterfaceBuilder {

     House house = new House();

    @Override
    public HeightHouse buildBasic() {
        System.out.println("建造高楼地基");
        house.basic = new Basic("200", "300", "200");
        return this;//返回当前对象
    }

    @Override
    public HeightHouse buildWall() {
        System.out.println("建造高楼墙面");
        house.wall = new Wall("blue","200");
        return this;//返回当前对象
    }

    @Override
    public HeightHouse buildRoof() {
        System.out.println("建造高楼屋顶");
        house.roof = new Roof("yellow","300");
        return this;//返回当前对象
    }

    @Override
    public House builder() {
        return house;//将产品返回过去
    }
}
