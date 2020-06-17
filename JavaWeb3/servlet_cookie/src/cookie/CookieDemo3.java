package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-24 11:21
 */
@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie c =new Cookie("msg","setMaxAge");
        //2.设置Cookie的存活时间  setMaxAge(int seconds) seconds为负数则为删除cookie 正数就是持久化cookie
        c.setMaxAge(30);
        //3.发送Cookie
        response.addCookie(c);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
