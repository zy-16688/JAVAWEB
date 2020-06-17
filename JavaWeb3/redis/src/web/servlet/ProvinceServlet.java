package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;
import service.ProvinceService;
import service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author nzy
 * @create 2020-05-11 10:26
 */
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //调用service获取信息
//        ProvinceService service = new ProvinceServiceImpl();
//        List<Province> list = service.findAll();
//        //序列化为json数据
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(mapper);
        ProvinceService service = new ProvinceServiceImpl();
        String  json = service.findAllJson();
        //响应数据
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
