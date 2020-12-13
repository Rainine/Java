package 策略模式.植物大战僵尸案例.产品.具体僵尸;

import com.sun.media.jfxmedia.control.MediaPlayerOverlay;
import 策略模式.植物大战僵尸案例.Service.Attack;
import 策略模式.植物大战僵尸案例.Service.Move;
import 策略模式.植物大战僵尸案例.ServiceImpl.AttackImpl.BiteServiceImpl;
import 策略模式.植物大战僵尸案例.ServiceImpl.MoveImpl.StepOneStepImpl;
import 策略模式.植物大战僵尸案例.产品.Zombie;

/**
 * @author lxy
 * @date 2020/12/13 12:41
 **/
public class BigHeadZombie implements Zombie {

    private Move move;
    private Attack attack;

    public BigHeadZombie() {
        /**已经默认初始化僵尸攻击和移动方式*/
        attack = new BiteServiceImpl();
        move = new StepOneStepImpl();
    }

    @Override
    public void display() {
        System.out.println("我是大头僵尸");
    }

    @Override
    public void moveSelf() {
        this.move.move();
    }

    @Override
    public void attackSelf() {
        this.attack.attack();
    }

    @Override
    public void setMove(Move move) {
        this.move = move;
    }

    @Override
    public void setAttack(Attack attack) {
        this.attack = attack;
    }


}
