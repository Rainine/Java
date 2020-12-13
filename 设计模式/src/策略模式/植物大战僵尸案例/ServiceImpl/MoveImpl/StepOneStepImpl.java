package 策略模式.植物大战僵尸案例.ServiceImpl.MoveImpl;

import 策略模式.植物大战僵尸案例.Service.Move;

/**
 * @author lxy
 * @date 2020/12/13 12:30
 **/
public class StepOneStepImpl implements Move {

    @Override
    public void move() {
        System.out.println("一步一步移动,初级僵尸");
    }
}
