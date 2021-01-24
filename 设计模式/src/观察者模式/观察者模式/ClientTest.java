package 观察者模式.观察者模式;

/**
 * @author lxy
 * @date 2021/1/24 12:54
 **/
public class ClientTest {

    public static void main(String[] args) {
        final CurrentConditions currentConditions = new CurrentConditions();
        final WeChat weChat = new WeChat();
        final WeatherData weatherData = new WeatherData(currentConditions);
        //添加新用户
        weatherData.setWeatherData(weChat);
        weatherData.setData(12,32,43);
        System.out.println("气温变了.....................");
        weatherData.setData(42,0,34);
        System.out.println("微信注销了");
        //注销用户
        weatherData.removerUser(weChat);
        weatherData.setData(12,32,43);
        System.out.println("气温变了.....................");
        weatherData.setData(42,0,34);
    }
}
