package 策略模式.植物大战僵尸案例.工厂;

import 策略模式.植物大战僵尸案例.Service.Attack;
import 策略模式.植物大战僵尸案例.ServiceImpl.AttackImpl.BitServiceImpl;
import 策略模式.植物大战僵尸案例.ServiceImpl.AttackImpl.BiteServiceImpl;

/**
 * @author lxy
 * @date 2020/12/14 10:24
 **/
public class BeanFactory {

    public static Attack getBean(Class clazz)  {
        if(clazz == null){
            throw  new InternalError("对不起您输入的 clazz 不能为空");
        }
        if (BiteServiceImpl.class.equals(clazz)) {
            return new BiteServiceImpl();
        } else if (BitServiceImpl.class.equals(clazz)) {
            return new BitServiceImpl();
        }
        return null;
    }

}
