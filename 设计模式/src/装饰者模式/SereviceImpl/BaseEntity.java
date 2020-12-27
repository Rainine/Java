package 装饰者模式.SereviceImpl;

/**
 * @author lxy
 * @date 2020/12/20 15:59
 **/

public  class  BaseEntity extends CalculatePrice {

     private String des;

     private float price;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public float calculatePrice() {
        return getPrice();
    }
}
