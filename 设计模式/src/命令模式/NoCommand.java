package 命令模式;

/**
 * @author lxy
 * @date 2021/1/10 16:34
 **/
public class NoCommand implements Command {

    /***
     * 没有任何命令,即空判断,用于初始化每个按钮,当调用空命令时,对象什么都不做,其实,这样是一种设计模式,省掉了空判断
     */



    @Override
    public void execute() {

    }

    @Override
    public void undo() {


    }
}
