package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSpinnerUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author nzy
 * @create 2020-04-22 22:38
 */
@WebServlet("/request1")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //BufferedReader getReader()  获取请求体数据  post方式的参数需要这样获取
        //        获取字符流
        BufferedReader br = req.getReader();
        String line = null;
        //读取数据
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
