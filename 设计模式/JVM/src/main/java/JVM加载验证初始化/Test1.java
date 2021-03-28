package JVM加载验证初始化;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author lxy
 * @date 2021/3/22 16:12
 **/
public class Test1 {

    public static void main(String[] args) {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));

    }

}
