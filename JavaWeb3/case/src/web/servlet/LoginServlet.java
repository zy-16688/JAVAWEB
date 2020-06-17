package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author nzy
 * @create 2020-04-25 18:23
 */

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取用户填写的验证码
        String checkcode = req.getParameter("verifycode");
        HttpSession session = req.getSession();
        //获取页面生成的验证码
        String checkcode_session = (String) session.getAttribute("checkcode");
        //每次更新验证码
        session.removeAttribute("checkcode");
        if (!checkcode_session.equalsIgnoreCase(checkcode)) {
            //验证码错误  保存错误消息 转发到登陆页面
            req.setAttribute("login_msg", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        //验证码正确后  获取参数信息
        Map<String, String[]> map = req.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调动业务层进行业务处理
        UserService service = new UserServiceImpl();
        User user = service.login(loginUser);
        if(user!=null){
            //登陆成功
            session.setAttribute("user",user);
            //重定向到index.jsp
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }else{
            //密码错误
            req.setAttribute("login_msg","密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

        @Override
        protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req, resp);
        }
    }
