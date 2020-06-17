package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author nzy
 * @create 2020-04-22 21:50
 */
@WebServlet(value = "/servlet6")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头为user-agent(返回浏览器的信息)的请求头的值
        String agent = request.getHeader("user-agent");
        //判断值中包含Chrome则为谷歌浏览器
        if(agent.contains("Chrome")){
            System.out.println("谷歌");
        }else  if(agent.contains("Firefox")){
            System.out.println("火狐");
        }
    }
}
