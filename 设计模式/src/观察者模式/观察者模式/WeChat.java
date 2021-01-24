package 观察者模式.观察者模式;

/**
 * @author lxy
 * @date 2021/1/24 13:39
 **/
public class WeChat implements  Observe {
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
        System.out.println("*WeChat****Today***temperature*****"+temperature+" ^C*************");
        System.out.println("*WeChat****Today***pressure*****"+pressure+" ^C*************");
        System.out.println("*WeChat****Today***humidity*****"+humidity+" ^C*************");
    }
}
