package cn.nzy.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-23 17:27
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo1");
        //访问responseDemo1会自动跳转到/reponseDemo2资源
      /*  1.设置响应行状态码302  重定向
        resp.setStatus(302);
        2.设置响应头location  和要跳转的路径
        resp.setHeader("location","/servlet_response_war_exploded/responseDemo2");*/
        //简单的重定向方法  sendRedirect(String path)
        resp.sendRedirect("/servlet_response_war_exploded/responseDemo2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req,resp);
    }
}
