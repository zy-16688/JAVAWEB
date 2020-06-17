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
@WebServlet(value = "/servlet5")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Enumeration<String> getHeaderNames()  获取请求头名称
        Enumeration<String> hearderNames = request.getHeaderNames();
        //hasMoreElements() 查看是否遍历结束
        while(hearderNames.hasMoreElements()){
            //nextElement()  下一个元素
            String name = hearderNames.nextElement();
            //String getHeader(name)  通过请求头名称来获取请求值的名称
            String value = request.getHeader(name);
            System.out.println(name+"---"+value);
        }
    }
}
