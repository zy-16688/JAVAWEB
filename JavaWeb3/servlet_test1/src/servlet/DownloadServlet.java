package servlet;

import utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author nzy
 * @create 2020-04-24 0:27
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        ServletContext context = this.getServletContext();
        String realpath = context.getRealPath("/img/"+filename);
        FileInputStream fis =new FileInputStream(realpath);
        String agent = req.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent,filename);
        String mimeType = context.getMimeType(filename);
        resp.setHeader("content-type",mimeType);
        resp.setHeader("content-disposition","attachment;filename"+filename);
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff  = new byte[1024];
        int len = 0;
        while((len=fis.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
        fis.close();
     }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
