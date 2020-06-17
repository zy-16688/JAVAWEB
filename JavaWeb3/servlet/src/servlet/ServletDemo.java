package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-22 17:04
 */
//@WebServlet(urlPatterns="/demo")  使用注解配置 @WebServlet("资源路径")
@WebServlet(value="/demo")
public class ServletDemo implements Servlet {
    /**
     * 初始化(创建方法)加载资源
     * 只执行一次
     * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }
    /**
     * 获取配置信息
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
        System.out.println("3.0");
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

    }
}
