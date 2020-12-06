package Interface;

/**
 * @author lxy
 * @date 2020/11/22 17:02
 **/
public class Son implements Apple {

    @Override
    public String returnName(String name) {
        return "我是"+name+"我有个姐姐";
    }

    @Override
    public String returnAge(int age) {
        return "我今年"+age+"岁了,我姐姐比我大2岁";
    }
}
