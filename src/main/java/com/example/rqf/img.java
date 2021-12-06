package com.example.rqf;
import org.junit.Test;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
//该类包含一些用来查找 ImageReader 和 ImageWriter 以及执行简单编码和解码的静态便捷方法。
public class img {
    //学习如何把一个字符串变成图片写到一个文件
    @Test
    public void ImgDemo1() throws FileNotFoundException, IOException{
        BufferedImage img = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        // 表示一个图像，它具有合成整数像素的 8 位 RGB 颜色分量。
        Graphics g = img.getGraphics();
        g.drawString("张钟小baby",10,20);
        //使用此图形上下文的当前字体和颜色绘制由指定 string 给定的文本。最左侧字符的基线位于此图形上下文坐标系的 (x, y) 位置处。
        g.dispose();////类似于流中的close()带动flush()---把数据刷到img对象当中
        //释放此图形的上下文以及它使用的所有系统资源。调用 dispose 之后，就不能再使用 Graphics 对象。
        ImageIO.write(img, "JPG", new FileOutputStream("D:\\666\\a.jpg"));
        //使用支持给定格式的任意 ImageWriter 将一个图像写入 File。
    }
}
