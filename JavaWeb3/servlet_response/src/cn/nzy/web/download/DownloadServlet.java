package cn.nzy.web.download;

import cn.nzy.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
/*
* * 分析：
		1. 超链接指向的资源如果能够被浏览器解析，则在浏览器中展示，如果不能解析，则弹出下载提示框。不满足需求
		2. 任何资源都必须弹出下载提示框
		3. 使用响应头设置资源的打开方式：
			* content-disposition:attachment;filename=xxx


	* 步骤：
		1. 定义页面，编辑超链接href属性，指向Servlet，传递资源名称filename
		2. 定义Servlet
			1. 获取文件名称
			2. 使用字节输入流加载文件进内存
			3. 指定response的响应头： content-disposition:attachment;filename=xxx
			4. 将数据写出到response输出流

* */
/**
 * @author nzy
 * @create 2020-04-23 23:02
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取参数文件的名称
        String filename =  req.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/"+filename);
       //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        //解决中文文件问题
        //1.获取user-agent请求头
        String agent = req.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent,filename);
        //3.设置response的响应头
        //3.1设置响应头类型 content-type 服务器告诉客户端响应体数据格式以及编码格式
        String mimeType = context.getMimeType(filename); //获取mime类型
        resp.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式  content-disposition  服务器告诉客户端以什么格式响应体数据
        resp.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff = new byte[1024];
        int len=0;
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
