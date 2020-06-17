package cn.nzy.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**获取ServletContext对象
 * @author nzy
 * @create 2020-04-23 22:02
 */
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext  getServletContext()
        ServletContext context1 = req.getServletContext();
        ServletContext context2 = this.getServletContext();
        System.out.println(context1);
        System.out.println(context2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req,resp);
    }
}
