package request;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/request7")
public class RequsetDemo7 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("88888");
        //RequestDispatcher getRequestDispatcher(String path) 通过req对象获取请求转发器 并指定要跳转的位置path
        //foward(req,resp)  使用requestDispatcher对象进行转发
        /*
        * 特点:
        *       1.浏览器地址栏路径不发生变化
        *       2.只能转发到当前服务器内部资源中
        *       3.转发是一次请求
        * */
        //request域:代表一次请求的范围 用于请求转发的多个资源中共享数据
        //void setAttribute(String name,Object obj)  存储数据
        //Object getAttribute(String name) 根据键获取值
        //void removeAttribute(String name) 通过键移除值
        req.setAttribute("username","haha");

        /*RequestDispatcher requestDispatcher = req.getRequestDispatcher("/request8");
        requestDispatcher.forward(req,resp);*/
        req.getRequestDispatcher("/request8").forward(req,resp);
    }

    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
