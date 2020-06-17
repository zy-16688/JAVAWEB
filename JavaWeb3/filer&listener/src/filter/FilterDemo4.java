package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-27 14:02
 */
@WebFilter("/*")
public class FilterDemo4 implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("demo4执行");
        chain.doFilter(req, resp);
        System.out.println("demo4回来了");
    }

    @Override
    public void destroy() {
    }


}
