package 装饰者模式.SereviceImpl.Entity.SeasoningEntity;

import 装饰者模式.SereviceImpl.BaseEntity;
import 装饰者模式.SereviceImpl.CalculatePrice;

/**
 * @author lxy
 * @date 2020/12/20 16:07
 **/
public class ChocolateEntity extends BaseEntity{

    public ChocolateEntity(CalculatePrice calculatePrice){

        setDes("巧克力");
        setPrice(5.0f);
    }

}
