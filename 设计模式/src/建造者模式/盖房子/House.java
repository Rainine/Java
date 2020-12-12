package 建造者模式.盖房子;

/**
 * @author lxy
 * @date 2020/12/12 14:00
 **/
/**复杂的产品*/
public class House {
    /**房子的每个属性都是由另一个对象构成*/
     Basic basic;
     Wall wall;
     Roof roof;

    @Override
    public String toString() {
        return "House{" +
                "basic=" + basic +
                ", wall=" + wall +
                ", roof=" + roof +
                '}';
    }
}
class Basic{
    private String length;
    private String height;

    private String width;

    @Override
    public String toString() {
        return "Basic{" +
                "length='" + length + '\'' +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                '}';
    }

    public Basic(String length, String height, String width) {
        this.length = length;
        this.height = height;
        this.width = width;

    }
}
class Wall{
    private String color;
    private String height;

    @Override
    public String toString() {
        return "Wall{" +
                "color='" + color + '\'' +
                ", height='" + height + '\'' +
                '}';
    }

    public Wall(String color, String height) {
        this.color = color;
        this.height = height;
    }
}
class Roof{

    private String color;
    private String length;

    @Override
    public String toString() {
        return "Roof{" +
                "color='" + color + '\'' +
                ", length='" + length + '\'' +
                '}';
    }

    public Roof(String color, String length) {
        this.color = color;
        this.length = length;
    }
}