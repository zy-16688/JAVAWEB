package servlet;

import dao.UserDao;
import domain1.User1;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author nzy
 * @create 2020-04-24 20:18
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的编码
        req.setCharacterEncoding("utf-8");
        //获取参数的Map集合
        Map<String,String[]> map = req.getParameterMap();
       User1 loginUser = new User1();
        try {
            //将map集合封装为user对象
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.获取生成的验证码
        HttpSession session = req.getSession();  //获取session
        String  checkCode_session = (String)session.getAttribute("checkCode_session");  //获取session中对应键的值
        String checkCode=req.getParameter("checkCode");   //获取客户端的验证码参数
        //删除验证码
        req.removeAttribute("checkCode_session");   //每获取了一次验证码就将session中的验证码信息移除
        UserDao dao = new UserDao();
        System.out.println(checkCode_session.equalsIgnoreCase(checkCode));
        //判断验证码是否正确  忽略大小写比较
        if(checkCode_session!=null&&checkCode_session.equalsIgnoreCase(checkCode)){
                //验证码正确
                //判断用户名和密码是否一致
                if(dao.login(loginUser)!=null){
                   //登陆成功
                    session.setAttribute("user", loginUser.toString());
                    //重定向到成功jsp页面
                    resp.sendRedirect(req.getContextPath()+"/success.jsp");
                }else{
                    //登陆失败
                    req.setAttribute("login_error","用户信息错误");
                    //转发到登陆页面
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);
                }
        }else {
            //验证码错误
            req.setAttribute("cc_error","验证码错误");
            //将错误信息转发到页面上
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
