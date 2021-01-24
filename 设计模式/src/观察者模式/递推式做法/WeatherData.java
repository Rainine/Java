package 观察者模式.递推式做法;

/**
 * @author lxy
 * @date 2021/1/24 12:49
 **/
/**气象局*/
public class WeatherData {
private float temperature;
private float pressure;
private float humidity;
private CurrentConditions currentConditions;
public WeatherData(CurrentConditions currentConditions){
    this.currentConditions = currentConditions;
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
    public  void dataChange(){
    currentConditions.update(getTemperature(),getPressure(),getHumidity());
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }
}
