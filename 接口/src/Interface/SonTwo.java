package Interface;

/**
 * @author lxy
 * @date 2020/11/22 17:04
 **/
public class SonTwo implements  Apple {

    @Override
    public String returnName(String name) {
        return "我叫"+name+"我有个哥哥";
    }

    @Override
    public String returnAge(int age) {
        return "我哥哥今年"+age+"岁了";
    }
}
