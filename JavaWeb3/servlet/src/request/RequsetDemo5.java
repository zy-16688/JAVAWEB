package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author nzy
 * @create 2020-04-22 23:08
 */
@WebServlet("/request2")
public class RequsetDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post 获取请求参数
        //根据参数名称来获取参数值   String getParameter(name)
        String name = req.getParameter("username");
        System.out.println(name);

        //根据参数名称获取参数值的数组 通常用于复选框  String[] getParameterValues(String name)
        String[] hobbies = req.getParameterValues("hobby");
        for(String hobby:hobbies){
            System.out.println(hobby);
        }

        //获取所有请求的参数名称   Enumeration<String> getParameterNames()
        Enumeration<String> getParameterNames=req.getParameterNames();
        while(getParameterNames.hasMoreElements()){
            //遍历下个元素
            String parameterName = getParameterNames.nextElement();
            System.out.println(parameterName);
            System.out.println("-----");
            String value = req.getParameter(parameterName);
            System.out.println(value);
            System.out.println("------");
        }
        System.out.println("换方法了");
        //获取所有参数的map集合  Map<String,String[]> getParameterMap()
        Map<String,String[]> parameterMap = req.getParameterMap();
        //通过keyset来遍历map集合
        Set<String> keyset = parameterMap.keySet();
        for(String key : keyset){
            //获取key对应的值
            String[] values = parameterMap.get(key);
            System.out.println(key);
            //遍历值的数组
            for(String value : values){
                System.out.println(value);
            }
            System.out.println("---------");
         }
    }

    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //两个方法的代码没有区别因此直接调用Post方法即可
        doPost(req,resp);
    }
}
