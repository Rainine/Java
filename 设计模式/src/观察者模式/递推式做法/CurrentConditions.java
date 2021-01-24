package 观察者模式.递推式做法;

/**
 * @author lxy
 * @date 2021/1/24 12:44
 **/
/**外部网站*/
public class CurrentConditions {
    //温度 气压 湿度
    private float temperature;
    private float pressure;
    private float humidity;
    public  void update(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        disPlay();
    }
    public void disPlay(){
        System.out.println("*****Today***temperature*****"+temperature+" ^C*************");
        System.out.println("*****Today***pressure*****"+pressure+" ^C*************");
        System.out.println("*****Today***humidity*****"+humidity+" ^C*************");
    }

}
