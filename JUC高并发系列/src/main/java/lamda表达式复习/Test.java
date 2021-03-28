package lamda表达式复习;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lxy
 * @date 2021/2/27 14:38
 **/
public class Test {

    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public void sout(int x, int y) {
                System.out.println("sout" + (x + y));

            }
        };
        System.out.println(foo.reduce(2, 3));
        System.out.println(foo.add(2, 3));


    }
}

interface Foo {

    public void sout(int x, int y);

    default int add(int x, int y) {
        return x + y;
    }

    default int reduce(int x, int y) {
        return x - y;
    }

    static int stati(int x, int y) {

        return x / y;

    }
}
