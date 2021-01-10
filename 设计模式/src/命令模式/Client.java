package 命令模式;

import 命令模式.TV.TVOffCommand;
import 命令模式.TV.TVOnCommand;
import 命令模式.TV.TVReceiver;
import 命令模式.light.LightOffCommand;
import 命令模式.light.LightOnCommand;
import 命令模式.light.LightReceiver;

/**
 * @author lxy
 * @date 2021/1/10 16:54
 **/
public class Client {

    public static void main(String[] args) {
        //创建电灯对象(接收者)
        final LightReceiver lightReceiver = new LightReceiver();
         //创建电灯相关的开关命令
       LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
       LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
       //需要一个遥控器
        final RemoteConteoller remoteConteoller = new RemoteConteoller();
        //给我们要控器设置相关命令
        remoteConteoller.setCommand(0,lightOnCommand,lightOffCommand);
        System.out.println("************按下灯的开的按钮***********");
        remoteConteoller.onButtonWasPushed(0);
        System.out.println("************按下灯的关的按钮***********");
        remoteConteoller.offButtonWasPushed(0);
        System.out.println("************按下灯撤销的按钮***********");

        remoteConteoller.undoButtonPush();
        System.out.println("*************************电视机*******************************8");

        //创建电灯对象(接收者)
        final TVReceiver tvReceiver = new TVReceiver();
        //创建电灯相关的开关命令
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
        //给我们要控器设置相关命令
        remoteConteoller.setCommand(1,tvOnCommand,tvOffCommand);
        System.out.println("************按下电视的开的按钮***********");
        remoteConteoller.onButtonWasPushed(1);
        System.out.println("************按下电视的关的按钮***********");
        remoteConteoller.offButtonWasPushed(1);
        System.out.println("************按下电视撤销的按钮***********");

        remoteConteoller.undoButtonPush();



    }

}
