package 命令模式.TV;

import 命令模式.Command;

/**
 * @author lxy
 * @date 2021/1/10 16:34
 **/
public class TVOffCommand implements Command {

    TVReceiver tvReceiver;

    public TVOffCommand(TVReceiver tvReceiver){
        this.tvReceiver = tvReceiver;
    }
    @Override
    public void execute() {
        tvReceiver.off();
    }

    @Override
    public void undo() {
        tvReceiver.on();
    }
}
