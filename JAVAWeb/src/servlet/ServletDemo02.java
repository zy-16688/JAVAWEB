package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-22 15:56
 */
public class ServletDemo02 implements Servlet {
    /**
     * 初始化方法  用于加载资源
     * 在Servlet被创建时 执行,只会执行一次
     * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }
    /**
     * 获取ServletConfig对象
     * ServletConfig: Servlet的配置对象
     * */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /**
     * 提供服务的方法
     * 每一次Servlet被访问时,都会执行一次,可执行多次
     * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...");
    }
    /**
     * 获取版本的信息
     * */
    @Override
    public String getServletInfo() {
        return null;
    }
    /**
     * 销毁方法   用于销毁资源
     * 在服务器正常关闭时,执行,执行一次
     * */
    @Override
    public void destroy() {
        System.out.println("destory..");
    }
}
