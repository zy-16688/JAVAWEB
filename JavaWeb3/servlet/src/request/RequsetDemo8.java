package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-22 23:08
 */
@WebServlet("/request8")
public class RequsetDemo8 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obj = req.getAttribute("username");
        System.out.println(obj);
        System.out.println("99999");
    }

    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //两个方法的代码没有区别因此直接调用Post方法即可
        doPost(req,resp);
    }
}
