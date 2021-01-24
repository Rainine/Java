package 观察者模式.观察者模式;

/**
 * @author lxy
 * @date 2021/1/24 12:49
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import 装饰者模式.DrinkService.CalculatePrice;

/**
 * 气象局
 */
public class WeatherData implements Register {

    private float temperature;
    private float pressure;
    private float humidity;
    private List<Observe> currentConditions = new ArrayList<>();

    /**
     * 最好不用构造器的方式来添加对象
     */
    public WeatherData(Observe currentConditions) {
        this.currentConditions.add(currentConditions);

    }

    public void setWeatherData(Observe currentConditions) {
        this.currentConditions.add(currentConditions);
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    /**
     * 给第三方推送消息
     */
    public void dataChange() {
        pushDate();
    }


    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    @Override
/**注册用户*/
    public void register(Observe observe) {
        currentConditions.add(observe);
    }

    @Override
/**用户注销*/
    public void removerUser(Observe observe) {
        if (currentConditions.contains(observe)) {
            currentConditions.remove(observe);
        }
    }

    @Override
    public void pushDate() {
        /**遍历所有观察者将数据推送给他们*/
        for (Observe currentCondition : currentConditions) {
            currentCondition.update(this.temperature, this.pressure, this.humidity);
        }
    }
}
