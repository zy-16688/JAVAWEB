package cn.nzy.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**重定向
 * @author nzy
 * @create 2020-04-23 17:27
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应头 content-type 告诉浏览器,服务器发送的数据的编码
        //resp.setHeader("content-type","text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //1.获取字符输出流
        PrintWriter pw = resp.getWriter();
        //2.输出数据  在消息体中有数据
        pw.write("<h1>你好a response</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
