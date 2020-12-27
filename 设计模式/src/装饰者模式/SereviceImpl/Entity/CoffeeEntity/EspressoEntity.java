package 装饰者模式.SereviceImpl.Entity.CoffeeEntity;

import 装饰者模式.SereviceImpl.BaseEntity;

/**
 * @author lxy
 * @date 2020/12/20 16:03
 **/
public class EspressoEntity extends BaseEntity {

    public EspressoEntity(){
        setDes("Espresson咖啡");
        setPrice(10.0f);
    }
}
