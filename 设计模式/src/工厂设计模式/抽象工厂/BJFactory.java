package 工厂设计模式.抽象工厂;

/**
 * @author lxy
 * @date 2020/12/6 13:27
 **/
public class BJFactory implements Factory{


    @Override
    public Phone createPhone(String type) {
        switch (type){
            case "white":return new BJWhitePhone();
            case "red" : return new BJRedPhone();
            default: return null;
        }
    }
}
