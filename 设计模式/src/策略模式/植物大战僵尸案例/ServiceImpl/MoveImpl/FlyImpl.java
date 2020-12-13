package 策略模式.植物大战僵尸案例.ServiceImpl.MoveImpl;

import 策略模式.植物大战僵尸案例.Service.Move;

/**
 * @author lxy
 * @date 2020/12/13 12:31
 **/
public class FlyImpl implements Move {

    @Override
    public void move() {
        System.out.println("升级版会飞的僵尸,就是这么牛逼");
    }
}
