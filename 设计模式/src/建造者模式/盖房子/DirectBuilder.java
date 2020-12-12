package 建造者模式.盖房子;

/**
 * @author lxy
 * @date 2020/12/12 14:13
 **/
public class DirectBuilder {

    private InterfaceBuilder interfaceBuilder;

    public DirectBuilder(InterfaceBuilder interfaceBuilder) {
        this.interfaceBuilder = interfaceBuilder;
    }
    public  House getResult(){
        interfaceBuilder.buildBasic();
        interfaceBuilder.buildWall();
        interfaceBuilder.buildRoof();
        return interfaceBuilder.builder();
    }
    public  void  setInterfaceBuilder(InterfaceBuilder interfaceBuilder){
        this.interfaceBuilder = interfaceBuilder;
    }

}
