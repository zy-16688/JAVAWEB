package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-27 13:38
 */
//dispatcherTypes 属性 REQUEST 浏览器直接请求资源  FORWAR 转发资源时执行过滤器
//@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//直接请求index.jsp或者转发访问index.jsp过滤器才会被执行
//@WebFilter(value="/index.jsp",dispatcherTypes={DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo3 implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo5");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
