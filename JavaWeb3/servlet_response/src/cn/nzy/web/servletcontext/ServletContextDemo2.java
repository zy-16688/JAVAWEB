package cn.nzy.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**获取MIME类型
 * @author nzy
 * @create 2020-04-23 22:02
 */
@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HTTP获取ServletContext
        ServletContext context  = this.getServletContext();
        String filename = "a.jpg";
        //获取了文件对应MIME类型   getMimeType(String filename)
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req,resp);
    }
}
