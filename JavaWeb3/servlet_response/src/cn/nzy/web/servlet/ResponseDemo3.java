package cn.nzy.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**重定向
 * @author nzy
 * @create 2020-04-23 17:27
 */
@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转发  是从服务器内部发出的 谁发出的就是给谁使用  因此不用添加虚拟目录
        req.getRequestDispatcher("/responseDemo2").forward(req,resp);
        //动态获取虚拟目录  getContextPath()
        String contexPath = req.getContextPath();
        //重定向  是从客户端浏览器发出的  需添加虚拟目录
        resp.sendRedirect(contexPath+"/responseDemo2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
