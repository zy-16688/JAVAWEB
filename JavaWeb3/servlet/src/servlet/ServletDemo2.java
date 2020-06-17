package servlet;

import com.sun.net.httpserver.HttpServer;
import org.omg.Messaging.SyncScopeHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-22 18:39
 */
//@WebServlet() 参数可以是一个数组
@WebServlet({"/d4","/d44"})
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("哈哈哈");
    }
}
