package proxy;

import org.omg.Messaging.SyncScopeHelper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author nzy
 * @create 2020-04-27 15:33
 */
public class ProxyTest {
    public static void main(String[] args) {
        //创建真实对象
        Lenovo lenovo = new Lenovo();
        //动态代理增强lenovo对象
        /*
        * 三个参数:
        * 1.类加载器:真实对象.getClass().getClassLoader()
        * 2.接口数组:真实对象/getClass().getInterfaces()
        * 3.处理器:new InvocationHandler()
        * */
        SaleComtuer proxy_lenovo =(SaleComtuer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
           /*
           * 代理逻辑编写的方法代理对象调用的所有方法都会触发该方法执行
               参数: 1.proxy 代理对象
               *    2.method 代理对象调用的方法 被封封装为的对象
               *    3.args:代理对象调用的方法时 传递的实际参数
           * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //判断是否是sale方法
                if(method.getName().equals(("sale"))){
                    //1.增强参数
                    double money = (double) args[0];
                    money = money*0.85;
                   //使用真实对象调用该方法
                    Object obj = method.invoke(lenovo,money);
                    return obj;
                }else {
                    Object obj = method.invoke(lenovo,args);
                    return obj;
                }


//
//                //打印出代理对象调用的方法的方法名
//                System.out.println(method.getName());
//                //打印出代理对象调用的方法时,传递的实际参数
//                System.out.println(args[0]);

            }
        });
        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);
    }

}
