package 观察者模式.观察者模式;

/**
 * @author lxy
 * @date 2021/1/24 13:27
 **/
public interface Register {
    public  void register(Observe observe);
    public  void removerUser(Observe observe);
    public void pushDate();
}
