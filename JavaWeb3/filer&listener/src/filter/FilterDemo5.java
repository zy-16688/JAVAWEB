package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-27 14:02
 */
//过滤器链的执行顺序根据过滤器所在的类名的字符串大小比较决定 值小的先执行
@WebFilter("/*")
public class FilterDemo5 implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("demo5执行了");
        chain.doFilter(req, resp);
        System.out.println("demo5回来了");
    }

    @Override
    public void destroy() {
    }


}
