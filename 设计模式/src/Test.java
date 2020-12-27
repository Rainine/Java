import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author lxy
 * @date 2020/12/16 10:40
 **/
public class Test {

    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        str.add("Silk-screen operation　丝印 ");
        System.out.println(str.contains("Silk-screen operation　丝印 "));
        Set<String> strr = new HashSet<>();
        strr.add("Silk-screen operation　丝印 ")  ;
        System.out.println(strr.contains("Silk-screen operation 丝印 "));
        for (int i=0;i<20;i++){

            System.out.println(UUID.randomUUID().toString()+"->"+System.currentTimeMillis());
        }
    }

}
