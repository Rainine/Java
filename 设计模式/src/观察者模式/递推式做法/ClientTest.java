package 观察者模式.递推式做法;

/**
 * @author lxy
 * @date 2021/1/24 12:54
 **/
public class ClientTest {

    public static void main(String[] args) {
        final CurrentConditions currentConditions = new CurrentConditions();
        final WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(12,32,43);
        System.out.println("气温变了.....................");
        weatherData.setData(42,0,34);
    }
}
