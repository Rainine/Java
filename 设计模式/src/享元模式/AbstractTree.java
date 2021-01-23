package 享元模式;

/**
 * @author lxy
 * @date 2021/1/23 15:15
 **/
/**游戏中的树木 把大树抽象出来
 * 游戏中的树相同种类的树长得一样,但是坐标不一样
 * */
abstract class AbstractTree {
  public    abstract void   growTree( Coordinate cooordinate);
}
