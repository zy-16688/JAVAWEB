package proxy;

/**
 * @author nzy
 * @create 2020-04-27 15:31
 */
public class Lenovo implements SaleComtuer{

    @Override
    public String sale(double money) {
        System.out.println("我花了"+money+"买了一台电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示一台电脑");
    }
}
