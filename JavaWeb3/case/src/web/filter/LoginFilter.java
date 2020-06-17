package web.filter;

import domain.PageBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**登录验证的过滤器
 * @author nzy
 * @create 2020-04-27 14:31
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        //获取资源的访问路径
        String uri = request.getRequestURI();
        //若用户访问的是登陆的资源的话就直接放行 包括登陆页面登陆验证资源css.js.还有验证码资源
        if(uri.contains("login.jsp")||uri.contains("/loginServlet")||uri.contains("/css/")||uri.contains("/fonts/")||uri.contains("/js/")||uri.contains("/checkcodeDemo")){
            chain.doFilter(req, resp);
        }else {   //否则就查看其是否登陆
            if(request.getSession().getAttribute("user")!=null){
                //若已经登陆则直接放行让其访问别的资源
                chain.doFilter(req,resp);
            }else {
                //存储错误信息 转发到登陆界面
                request.setAttribute("login_msg","您尚未登陆请登陆");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    @Override
    public void destroy() {
    }


}
