package 命令模式.light;

import 命令模式.Command;

/**
 * @author lxy
 * @date 2021/1/10 16:34
 **/
public class LightOnCommand implements Command {

    LightReceiver lightReceiver;

    public LightOnCommand(LightReceiver lightReceiver){
        this.lightReceiver = lightReceiver;
    }
    @Override
    public void execute() {
        lightReceiver.on();
    }

    @Override
    public void undo() {
           lightReceiver.off();
    }
}
