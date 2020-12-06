package 工厂设计模式.简单工厂;

/**
 * @author lxy
 * @date 2020/12/6 10:52
 **/
public class SimpleFactory {

    /**
     * 设计模式应对我们程序发展中的变化 一定要找到代码稳定的部分 -> 才可以引入设计模式 -> 一定要找到代码中变化中的稳定部分
     */
    /**********************************************************面向实现编程***也叫递推式编程************************************************************************/

    public static void main(String[] args) {
        Application application = new Application();
        Product producer = application.getObject();
        producer.createProducer();
    }
}
/**相当于业务层:createProducer() 相当于我们产品稳定的部分*/
class Product {
    public void createProducer() {
        System.out.println("createProducer method()");
    }
}
/**用来创建对象*/
class Application {
    public Product getProducer() {
        /** 此处还是略有问题,返回对象是唯一确定的一个,
         * 解决办法 -> 可以使用map,将所有已经知道的对象放在容器里,之后根据键值不同来取想要的对象
         * 或者使用swatch case 根据传入的参数不同来创建不同的对象*/
        return new Product();
    }
    public Product getObject() {
        Product producer = getProducer();
        /**业务中做一些处理,但是只能处理一个对象,如果是处理多个的话只能是处理公共部分,所以我们要扩展子类的话,这里没有办法扩展*/
        return producer;
    }
}
/**
 * 引入简单工厂 -> 切记一点 工厂是用来创建对象的 . 产品,我们要找到它稳定的部分,之后对稳定的部分进行抽象,也就是说我们所要抽象的东西都是稳定的
 */
/**********************************************************简单工厂***************************************************************************/
/**创建对象的工厂,根据传入的类型不同来创建对象**/
class SimpleFactory1 {

    public static Phone createObject(String type) {
        switch (type) {
            case "1":
                return new Product1();
            case "2":
                return new Product2();
            default:
                return null;
        }
    }
}
/**产品具体稳定的部分,用接口去做,eg:手机都有保存的功能,我们就把保存的功能抽象出来*/
interface Phone {
    public void save();
}
class Product1 implements Phone {
    @Override
    public void save() {
        System.out.println("Product()1 save()....");
    }
}
class Product2 implements Phone {
    @Override
    public void save() {
        System.out.println("Product()2 save()....");
    }
}
/**此处不应该来获取对象了
 * 应该是业务层的一部分
 * 在业务层调用,来实现某个具体步骤
 *
 * */
class ProductService {
    /**
     * 此处使用的是接口,这样返回的具体是哪个对象就由调用方决定了
     */
    public Phone getProducer(String type) {
        /**
         *
         * 创建对象两种方式
         * 1.简单工厂(属于一中编码的方式)
         * 2.工厂方法模式
         * */
        return SimpleFactory1.createObject(type);
    }
    /**
     * 用接口去接收 Phone producer = getProducer(type);
     */
    public Phone getObject(String type) {
        Phone producer = getProducer(type);
        /**按照业务去做处理
         * */
        return producer;
    }
}


class Test1 {
    public static void main(String[] args) {
        SimpleFactory1 fa = new SimpleFactory1();
        String type = "2";
        Phone object = fa.createObject(type);
        if(object != null) {object.save();}
        else{
            System.out.println("对不起 您输入的类型不未定义->type=" + type);
        }

//        ProductService fac = new ProductService();
//        String type = "8";
//        Common pro = fac.getObject(type);
//
//        if (pro != null) pro.save();
//        System.out.println("对不起 您输入的类型不未定义->type=" + type);

    }
}
/**********************************************************工厂方法***************************************************************************/

/**
 * 工厂方法模式 本质:产品具体实例化工程推迟到子类
 * 主要优点:
 * 1.符合开闭原则
 * 2.复合单一职责原则
 * 3.将产品和创建者解耦
 */
/**实现该接口的类叫业务层*/
interface Common2 {
    public void save();
}

class Product4 implements Common2 {
    @Override
    public void save() {
        System.out.println("Product()4 save()....");
    }
}

class Product3 implements Common2 {
    @Override
    public void save() {
        System.out.println("Product()3 save()....");
    }
}

interface ProductService2 {
     Common2 createObject();
}
/**创建对象的子类:不叫业务层*/
class CreateProduct3Service implements ProductService2 {

    @Override
    public Common2 createObject() {
        return new Product3();
    }
}

class CreateProduct4Service implements ProductService2 {
    @Override
    public Common2 createObject() {
        return new  Product4();
    }
}
class Test2 {
    public static void main(String[] args) {
        ProductService2 pro = new CreateProduct4Service();
        Common2 object = pro.createObject();
        object.save();
    }
}


