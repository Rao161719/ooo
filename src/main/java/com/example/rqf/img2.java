package com.example.rqf;
import org.junit.Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
//该类包含一些用来查找 ImageReader 和 ImageWriter 以及执行简单编码和解码的静态便捷方法。

public class img2 {
    @Test//可以旋转和放缩的验证码
    public void ImgDemo3() throws FileNotFoundException, IOException{
        int width = 100;
        int height = 50;
        int lines = 10;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D)img.getGraphics();

        g2d.setFont(new Font("宋体", Font.BOLD, 25));

        Random r = new Random(new Date().getTime());

        //设置背景色
        g2d.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g2d.drawRect(0, 0, width, height);//绘制指定矩形的边框。
        g2d.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g2d.fillRect(0, 0, width, height);//填充指定的矩形。

        for(int i=0;i<4;i++){
            String str = ""+r.nextInt(10);

            //处理旋转
            AffineTransform Tx = new AffineTransform();
            Tx.rotate(Math.random(), 5+i*15, height-5);
            //用弧度测量的旋转角度,旋转锚点的 X 坐标,旋转锚点的 Y 坐标
            g2d.setTransform(Tx);
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g2d.setColor(c);
            g2d.drawString(str, 2+i*width/4, height-20);
        }

        //干扰线
        for(int i=0;i<lines;i++){
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g2d.setColor(c);
            g2d.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
        }

        g2d.dispose();

        ImageIO.write(img, "JPG", new FileOutputStream("D:\\666\\c.jpg"));
    }
}
