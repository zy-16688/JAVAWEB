package cn.nzy.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 重定向
 *
 * @author nzy
 * @create 2020-04-23 17:27
 */
@WebServlet("/checkcodeDemo")
public class CheckCodeDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width=100;
        int height=50;
        //1.创建一个对象,在内存中图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();  //获取画笔
        g.setColor(Color.PINK);  //设置画笔颜色
        g.fillRect(0,0,width,height);
        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);
        //str是验证会出现的文字
        String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            //写验证码
            g.drawString(ch+"",width/5*i,height/2);
        }
        //2.3画干扰性
        for (int i = 0; i < 2; i++) {
            //随机生成width范围的数
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2= random.nextInt(height);
            g.drawLine(x1,x2,y1,y2);
        }
        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
