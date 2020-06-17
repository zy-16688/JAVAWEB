package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author nzy
 * @create 2020-04-26 16:00
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前的页码
        String currentpage = request.getParameter("currentpage");
        //获取一页显示的条目数
        String rows = request.getParameter("rows");
        //获取参数的Map集合
        Map<String, String[]> condition = request.getParameterMap();
        if(currentpage==null||"".equals(currentpage)){
            currentpage="1";
        }
        if(rows==null||"".equals(rows)){
            rows="2";
        }
        UserService service = new UserServiceImpl();
        //获取业务层处理后的数据
        PageBean<User> pb = service.findUserByPage(currentpage,rows,condition);
        //设置session
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //转发到另外的网站
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
