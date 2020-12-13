package 策略模式.植物大战僵尸案例.ServiceImpl.AttackImpl;

import 策略模式.植物大战僵尸案例.Service.Attack;

/**
 * @author lxy
 * @date 2020/12/13 12:27
 **/
/**用嘴咬攻击方式 -> 策略一 */
public class BiteServiceImpl implements Attack {
    @Override
    public void attack() {
        System.out.println("用嘴咬");
    }
}
