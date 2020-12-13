package 策略模式.植物大战僵尸案例.ServiceImpl.AttackImpl;

import 策略模式.植物大战僵尸案例.Service.Attack;

/**
 * @author lxy
 * @date 2020/12/13 12:28
 **/
public class BitServiceImpl implements Attack {

    @Override
    public void attack() {
        System.out.println("用手打它,揍死他,往冒烟了打");
    }
}
