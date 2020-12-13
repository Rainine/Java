package 策略模式.植物大战僵尸案例;

import com.sun.org.apache.xpath.internal.operations.Or;
import 策略模式.植物大战僵尸案例.Service.Attack;
import 策略模式.植物大战僵尸案例.ServiceImpl.AttackImpl.BitServiceImpl;
import 策略模式.植物大战僵尸案例.ServiceImpl.AttackImpl.BiteServiceImpl;
import 策略模式.植物大战僵尸案例.ServiceImpl.MoveImpl.FlyImpl;
import 策略模式.植物大战僵尸案例.ServiceImpl.MoveImpl.StepOneStepImpl;
import 策略模式.植物大战僵尸案例.产品.Zombie;
import 策略模式.植物大战僵尸案例.产品.具体僵尸.OrdinaryZombie;

/**
 * @author lxy
 * @date 2020/12/13 12:43
 **/
public class Test {

    public static void main(String[] args) {

        Zombie zombie = new OrdinaryZombie();
        zombie.display();
        zombie.moveSelf();
        zombie.attackSelf();
        System.out.println("********************************");
        zombie.setAttack(new BitServiceImpl());/**更改攻击方式*/
        zombie.attackSelf();
    }
}
