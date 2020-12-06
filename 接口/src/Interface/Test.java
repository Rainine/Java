package Interface;

/**
 * @author lxy
 * @date 2020/11/22 17:00
 **/
public class Test {

    public static void main(String[] args) {
        String lxy = getPerson(new Son(), "lxy", 12);
        System.out.println(lxy);
        String lsf = getPerson(new SonTwo(), "lsf", 19);
        System.out.println(lsf);


    }
    public static String getPerson(Apple son, String name, int age){

        String ages = son.returnAge(age);
        String names = son.returnName(name);
        return ages+"/"+names;


    }
}
