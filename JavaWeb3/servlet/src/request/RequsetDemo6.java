package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author nzy
 * @create 2020-04-22 23:08
 */
@WebServlet("/request3")
public class RequsetDemo6 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置流的字符编码  setCharacterEncoding("utf-8")
        req.setCharacterEncoding("utf-8");
        //根据请求参数名 获取请求参数值
        String name = req.getParameter("username");
        System.out.println(name);
    }

    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //两个方法的代码没有区别因此直接调用Post方法即可
        doPost(req,resp);
    }
}
