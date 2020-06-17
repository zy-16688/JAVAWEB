package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-27 10:11
 */
/*
* 拦截路径
* 1.拦截目录   /user/*   访问user目录下的资源时,过滤器会被执行
   2.后缀名拦截  *.jsp    访问所有的jsp文件时,过滤器会被执行
   3.所有资源   /*
 */

//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    //关闭服务器后执行
    @Override
    public void destroy() {
    }
    //每一次请求被拦截时,会执行,执行多次
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息进行增强
        System.out.println("哈哈哈");
        //放行
        chain.doFilter(req, resp);
        //对response对象的响应消息增强
        System.out.println("我回来了");
    }
    //服务器启动后,会创建filter对象,调用init方法只执行一次用于加载资源
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
