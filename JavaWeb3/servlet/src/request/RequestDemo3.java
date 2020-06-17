package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-22 21:50
 */
@WebServlet(value = "/servlet8")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据请求头referer(包含从哪个页面过来访问当前资源的信息)获取请求头的值
        String referer = request.getHeader("referer");
        System.out.println(referer);
        //防盗链
        if(referer.contains("/")){
            System.out.println("看电影啦");
        }else {
            System.out.println("看不了撒");
        }
    }
}
