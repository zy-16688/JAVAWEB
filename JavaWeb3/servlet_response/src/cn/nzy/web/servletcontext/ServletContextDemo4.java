package cn.nzy.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**获取文件的真实(服务器)路径
 * @author nzy
 * @create 2020-04-23 22:02
 */
@WebServlet("/servletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context   = this.getServletContext();
        //获取文件的(服务器)真实路径
        String path1  = context.getRealPath("/b.txt");  //获取web目录下的资源
        System.out.println(path1);
        String path2 = context.getRealPath("/WEB-INF/c.txt"); //获取WEB-INF目录下的资源
        System.out.println(path2);
        String path3 = context.getRealPath("/WEB-INF/classes/a.txt"); //获取src目录下的资源
        System.out.println(path3);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req,resp);
    }
}
