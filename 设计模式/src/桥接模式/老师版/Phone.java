package 桥接模式.老师版;

/**
 * @author lxy
 * @date 2020/12/27 17:17
 **/
 public abstract  class  Phone {
   private   Brand brand ;
   public Phone(Brand brand){
       this.brand = brand ;
   }
   public void call(){
       brand.call();
   }
   public void open(){
       brand.open();
   }
   public void close(){
       brand.close();
   }
}
