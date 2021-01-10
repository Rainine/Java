package 命令模式.light;

import org.omg.Messaging.SyncScopeHelper;

/**
 * @author lxy
 * @date 2021/1/10 16:35
 **/
public class LightReceiver
{
    public void on(){
        System.out.println("灯打开了");
    }
    public  void off(){
        System.out.println("灯关闭了");

    }

}
