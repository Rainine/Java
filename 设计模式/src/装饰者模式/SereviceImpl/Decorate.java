package 装饰者模式.SereviceImpl;

import 装饰者模式.DrinkService.CalculatePrice;

/**
 * @author lxy
 * @date 2020/12/20 16:43
 **/
public class Decorate implements CalculatePrice  {

    private CalculatePrice calculatePrice;


     public Decorate(CalculatePrice calculatePrice){
         this.calculatePrice = calculatePrice;
     }

    @Override
    public float getPrice() {
        return calculatePrice.getPrice();
    }

    @Override
    public String getDes() {
        return calculatePrice.getDes();
    }
}
