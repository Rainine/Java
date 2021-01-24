package 观察者模式.观察者模式;

/**
 * @author lxy
 * @date 2021/1/24 13:23
 **/
/**观察者接口*/
public interface Observe {
  public void update(float temperature,float pressure,float humidity);
}
