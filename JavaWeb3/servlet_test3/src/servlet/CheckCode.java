package servlet;

import com.sun.prism.paint.Color;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import static com.sun.prism.paint.Color.*;

/**
 * @author nzy
 * @create 2020-04-24 1:17
 */
@WebServlet("/checkcodeServlet")
public class CheckCode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width =100;
        int height= 100;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();  //获取画笔
        g.setColor(java.awt.Color.PINK);  //设置画笔颜色
        g.fillRect(0,0,width,height);

        g.setColor(java.awt.Color.GREEN);
        g.drawRect(0,0,width-1,height-1);
        String str ="ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        for(int i=1;i<=4;i++){
            int index = random.nextInt(str.length());
            char ch =str.charAt(index);
            g.drawString(ch+"",width/5*i,height/2);
        }

        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
