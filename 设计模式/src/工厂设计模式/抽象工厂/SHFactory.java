package 工厂设计模式.抽象工厂;

import java.lang.invoke.SwitchPoint;

/**
 * @author lxy
 * @date 2020/12/6 13:27
 **/
public class SHFactory implements Factory {

    @Override
    public Phone createPhone(String type) {
        switch (type){
            case "white":return new SHWhitePhone();
            case "red" : return new SHRedPhone();
            default: return null;
        }
    }
}
