package 策略模式.植物大战僵尸案例.产品;

/**
 * @author lxy
 * @date 2020/12/13 12:33
 **/

import 策略模式.植物大战僵尸案例.Service.Attack;
import 策略模式.植物大战僵尸案例.Service.Move;

/**抽象一下僵尸*/
public interface Zombie {
     public void display();//每个僵尸有自己的外观
     public void moveSelf();//调用移动方式
     public void  attackSelf();//调用攻击方式
     public void setMove(Move move);//用来更换移动方式
     public void setAttack(Attack attack);//用来更换攻击方式
}
