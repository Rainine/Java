package 装饰者模式.SereviceImpl.Entity.SeasoningEntity;

import 装饰者模式.SereviceImpl.BaseEntity;
import 装饰者模式.SereviceImpl.CalculatePrice;

/**
 * @author lxy
 * @date 2020/12/20 16:07
 **/
public class SoyEntity extends BaseEntity {
  public  SoyEntity(CalculatePrice calculatePrice){

      setDes("豆浆");
      setPrice(70.0f);
  }
}
