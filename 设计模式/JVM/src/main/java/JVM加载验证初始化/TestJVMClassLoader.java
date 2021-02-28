package JVM加载验证初始化;

import com.sun.crypto.provider.DESKeyFactory;

/**
 * @author lxy
 * @date 2021/2/20 13:04
 **/
public class TestJVMClassLoader {

    public static void main(String[] args) {

        System.out.println(String.class.getClassLoader());
        System.out.println(DESKeyFactory.class.getClassLoader());
        System.out.println(TestJVMClassLoader.class.getClassLoader());
        System.out.println();
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader =  appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassLoader.getParent();
        System.out.println("bootstrapLoader:"+bootstrapLoader);
        System.out.println("extClassLoader:"+extClassLoader);
        System.out.println("appClassLoader:"+appClassLoader);
    }
}
