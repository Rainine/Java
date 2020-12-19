import java.util.UUID;

/**
 * @author lxy
 * @date 2020/12/16 10:40
 **/
public class Test {

    public static void main(String[] args) {
        for (int i=0;i<20;i++){

            System.out.println(UUID.randomUUID().toString()+"->"+System.currentTimeMillis());
        }
    }

}
