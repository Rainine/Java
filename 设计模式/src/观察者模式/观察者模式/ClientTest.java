package 观察者模式.观察者模式;

import java.util.HashMap;

/**
 * @author lxy
 * @date 2021/1/24 12:54
 **/
public class ClientTest {

    public static void main(String[] args) {

        HashMap<String,String> sum = new HashMap<>();
                sum.put("1","qw");
                sum.put("2","qw1");
                sum.put("3","qw2");
                sum.put("4","qw3");
        System.out.println(  sum.get("5"));
        System.out.println("Map");





        final CurrentConditions currentConditions = new CurrentConditions();
        final WeChat weChat = new WeChat();
        final WeatherData weatherData = new WeatherData(currentConditions);
        //添加新用户
        weatherData.setWeatherData(weChat);
        weatherData.setData(12, 32, 43);
        System.out.println("气温变了.....................");
        weatherData.setData(42, 0, 34);
        System.out.println("微信注销了");
        //注销用户
        weatherData.removerUser(weChat);
        weatherData.setData(12, 32, 43);
        System.out.println("气温变了.....................");
        weatherData.setData(42, 0, 34);
    }
}
