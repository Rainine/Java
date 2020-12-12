package 建造者模式.盖房子;

/**
 * @author lxy
 * @date 2020/12/12 14:00
 **/
/**产品*/
public class House {
    private String basic;
    private String wall;
    private String roof;

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }
}
