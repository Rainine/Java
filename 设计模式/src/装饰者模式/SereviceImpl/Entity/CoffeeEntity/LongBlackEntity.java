package 装饰者模式.SereviceImpl.Entity.CoffeeEntity;

import 装饰者模式.SereviceImpl.BaseEntity;

/**
 * @author lxy
 * @date 2020/12/20 16:03
 **/
public class LongBlackEntity extends BaseEntity {
     public LongBlackEntity(){
         setDes("黑咖啡");
         setPrice(30.0f);
     }
}
