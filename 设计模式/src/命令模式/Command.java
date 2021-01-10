package 命令模式;

/**
 * @author lxy
 * @date 2021/1/10 16:31
 **/
//创建命令接口
public interface Command {
    //执行命令
    public void execute();
    //撤销某个动作
    public void undo();
}
