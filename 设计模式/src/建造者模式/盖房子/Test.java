package 建造者模式.盖房子;

/**
 * @author lxy
 * @date 2020/12/12 14:17
 **/
public class Test {

    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        DirectBuilder directBuilder = new DirectBuilder(commonHouse);
        directBuilder.getResult();
        System.out.println("*******************************************");
        HeightHouse heightHouse = new HeightHouse();
        directBuilder.setInterfaceBuilder(heightHouse);
        directBuilder.getResult();
    }

}
