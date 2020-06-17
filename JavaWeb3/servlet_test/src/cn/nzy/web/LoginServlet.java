package cn.nzy.web;

import cn.nzy.dao.UserDao;
import cn.nzy.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author nzy
 * @create 2020-04-23 15:01
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取参数
      /*  String username = req.getParameter("username");
        String password = req.getParameter("password");
        //将参数封装成User对象
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);*/
      //2.获取所有请求参数
        Map<String,String[]> map = req.getParameterMap();
        //3.创建User对象
        User loginuser = new User();
        try {
            //3.1 使用BeanUtils将map集合中的信息封装到User对象中
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //创建UserDao对象 并调用login方法登陆
        UserDao dao  =new UserDao();
        User user = dao.login(loginuser);

        if(user==null){
            //登陆失败  转发到failServlet
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            //登陆成功  转发到successServlet
            //保存用户的数据
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

}
