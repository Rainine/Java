package 装饰者模式.SereviceImpl.Entity.CoffeeEntity;

import 装饰者模式.SereviceImpl.BaseEntity;

/**
 * @author lxy
 * @date 2020/12/20 16:03
 **/
public class ShortBlack extends BaseEntity {

    public ShortBlack(){
        setDes("short 咖啡");
        setPrice(40.0f);
    }
}
