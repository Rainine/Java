package 建造者模式.盖房子;

/**
 * @author lxy
 * @date 2020/12/12 14:17
 **/
public class Test {

    public static void main(String[] args) {
        /**最主要一点,链式编程*/
        System.out.println("******************方式1*************************");
        HeightHouse heightHouse = new HeightHouse();
        DirectBuilder builder1 = new DirectBuilder(heightHouse);
/**最主要一点,链式编程*/        House house1 = builder1.buildBasic().builder();//仅打地基
        System.out.println(house1);
        System.out.println("*******************方式2*************************");
        CommonHouse commonHouse1 = new CommonHouse();
        DirectBuilder directBuilder1 = new DirectBuilder(commonHouse1);
/**最主要一点,链式编程*/        House house2 = directBuilder1.buildWall().buildBasic().builder();//打地基和造墙
       System.out.println(house2);

        System.out.println("*******************方式3*************************");
        CommonHouse build = new CommonHouse();
/**最主要一点,链式编程*/        House house3 = build.buildBasic().buildWall().buildRoof().builder();//打地基,垒墙,上盖
        System.out.println(house3);

    }

}
