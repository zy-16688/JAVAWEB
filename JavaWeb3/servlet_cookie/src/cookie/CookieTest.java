package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 1. 有：不是第一次访问
 1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 2. 没有：是第一次访问
 1. 响应数据：您好，欢迎您首次访问
 2. 写回Cookie：lastTime=2018年6月10日11:50:01

 */
/**
 * @author nzy
 * @create 2020-04-24 11:21
 */
@WebServlet("/cookieDemo5")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //设置响应的消息体的编码和数据格式
            response.setContentType("text/html;charset=utf-8");
           //1.获取浏览器客户端中的cookie数据(都是持久化的数据)
            Cookie[] cookies = request.getCookies();
            //设置一个标记判断是否访问过该资源
            boolean  flag = false;  //初始化false表示没有访问过
            //2.遍历cookie数组
            if(cookies!=null&&cookies.length>0){
                for(Cookie cookie : cookies){
                    //3.获取每个cookie的名称
                    String name = cookie.getName();
                    //4.判断名称  说明访问过,不是第一次访问过
                    if("lasttime".equals(name)){
                       //修改标志
                        flag  = true;
                        //重新设置cookie的value值
                        Date date =new Date();
                        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String last_time=sdf.format(date);
                        //URL编码
                        last_time = URLEncoder.encode(last_time,"utf-8");
                        cookie.setValue(last_time);
                        //设置cookie的存活时间
                        cookie.setMaxAge(60*60*24*30);
                        //将新cookie数据响应到客户端
                        response.addCookie(cookie);

                        //响应数据
                        String value = cookie.getValue();
                        //URL解码
                        value = URLDecoder.decode(value,"utf-8");
                        //将数据响应到客户端上
                        response.getWriter().write("欢迎回来您上次访问的时间为"+value);
                        break;
                    }
                }
            }
            //没被访问过
            if(cookies==null||cookies.length==0||flag==false){
                //设置Cookie的value
                //获取当前时间的字符串  重新设置Cookie的值,重新发送Cookie
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(date);
                time  = URLEncoder.encode(time,"utf-8");
                Cookie c = new Cookie("lasttime",time);
                //设置cookie的值
                c.setMaxAge(60*60*24*30);
                response.addCookie(c);
                response.getWriter().write("欢迎新用户");
            }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
