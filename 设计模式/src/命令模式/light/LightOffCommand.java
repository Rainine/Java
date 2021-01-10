package 命令模式.light;

import 命令模式.Command;

/**
 * @author lxy
 * @date 2021/1/10 16:34
 **/
public class LightOffCommand implements Command {

    LightReceiver lightReceiver;

    public LightOffCommand(LightReceiver lightReceiver){
        this.lightReceiver = lightReceiver;
    }
    @Override
    public void execute() {
        lightReceiver.off();
    }

    @Override
    public void undo() {
           lightReceiver.on();
    }
}
