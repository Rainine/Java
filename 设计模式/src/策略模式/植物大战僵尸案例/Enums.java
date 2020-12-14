package 策略模式.植物大战僵尸案例;

import 策略模式.植物大战僵尸案例.ServiceImpl.AttackImpl.BitServiceImpl;
import 策略模式.植物大战僵尸案例.ServiceImpl.AttackImpl.BiteServiceImpl;

/**
 * @author lxy
 * @date 2020/12/14 10:13
 **/
public enum Enums {
    bite(BiteServiceImpl.class),
    bit(BitServiceImpl.class);
    private Class clazz;

     Enums(Class clazz){
        this.clazz = clazz;
    }

    public Class getClazz(){
        return clazz;
    }
}
