package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author nzy
 * @create 2020-04-27 17:20
 */
public class ContextLoadListener implements ServletContextListener {
    /*
    * 监听ServletContext对象创建 Servlet对象服务器开启后自动创建
    * */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被创建了");
    }
    /**
     * 在服务器关闭后Servlet对象被销毁  当服务器正常关闭后该方法被调用
     * */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁了");
    }
}
