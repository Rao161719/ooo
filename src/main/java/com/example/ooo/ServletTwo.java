package com.example.ooo;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class ServletTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 80;
        int height= 40;
        int lines = 10;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();

        //设置背景色
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);//画背景
        //填充指定的矩形。使用图形上下文的当前颜色填充该矩形
        //设置字体
        g.setFont(new Font("宋体", Font.BOLD, 22));
        //随机数字
        Date d = new Date();
        Random r = new Random(d.getTime());
        for(int i=0;i<4;i++){
            int a = r.nextInt(10);//取10以内的整数[0，9]
            int y = 10+r.nextInt(20); //10~30范围内的一个整数，作为y坐标
            System.out.println(a+" "+y);
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(c);
            g.drawString(""+a, 5+i*width/4, y);
        }
        System.out.println("--------");
        //干扰线
        for(int i=0;i<lines;i++){
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(c);
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
        }
        g.dispose();//类似于流中的close()带动flush()---把数据刷到img对象当中
        ImageIO.write(img, "JPG", response.getOutputStream());

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
