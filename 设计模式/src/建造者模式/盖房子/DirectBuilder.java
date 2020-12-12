package 建造者模式.盖房子;

import org.omg.CORBA.INTERNAL;

/**
 * @author lxy
 * @date 2020/12/12 14:13
 **/
public class DirectBuilder {

    private InterfaceBuilder interfaceBuilder;

    public DirectBuilder(InterfaceBuilder interfaceBuilder) {
        this.interfaceBuilder = interfaceBuilder;
    }
    public void setInterfaceBuilder(InterfaceBuilder interfaceBuilder) {
        this.interfaceBuilder = interfaceBuilder;
    }

    public InterfaceBuilder buildBasic() {
        InterfaceBuilder interfaceBuilder = this.interfaceBuilder.buildBasic();
        return interfaceBuilder;
    }

    public InterfaceBuilder buildWall() {
        InterfaceBuilder interfaceBuilder = this.interfaceBuilder.buildWall();
        return interfaceBuilder;
    }

    public InterfaceBuilder buildRoof() {
        InterfaceBuilder interfaceBuilder = this.interfaceBuilder.buildRoof();
        return interfaceBuilder;
    }
    public  House buildHouse(){
        House house = this.interfaceBuilder.builder();
        return house;
    }

}
