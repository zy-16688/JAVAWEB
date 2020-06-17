package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-22 21:24
 */
@WebServlet("/servlet4")
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求方式
        String method = request.getMethod();
        System.out.println(method);
        //获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //获取get方式的请求参数  username="zhansan"
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //获取servlet路径 资源路径
        String  servletPath = request.getServletPath();
        System.out.println(servletPath);
        //获取URI和URL   URI统一资源标识符  URL统一资源定位符
        String URI = request.getRequestURI();
        StringBuffer URL = request.getRequestURL();
        System.out.println(URI);
        System.out.println(URL);
        //协议版本
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //客户机的ip地址
        String ip =request.getRemoteAddr();
        System.out.println(ip);
    }
}
