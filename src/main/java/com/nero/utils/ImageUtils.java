package com.nero.utils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2023-02-14
 * Time: 11:04
 */

import com.sun.imageio.plugins.common.ImageUtil;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * add by sn
 */
public class ImageUtils {

    /**
     * 按照宽高比例压缩
     *
     * @param img    图片
     * @param width  指定压缩的宽度
     * @param height 指定压缩的高度
     */
    public static void thumbnail_w_h(File img, int width, int height, OutputStream out) throws IOException {
        BufferedImage bi = ImageIO.read(img);
        double srcWidth = bi.getWidth();    // 源图宽度
        double srcHeight = bi.getHeight();  // 源图高度

        double scale = 1;

        // 压缩比例
        if (width > 0) {
            scale = width / srcWidth;
        }
        if (height > 0) {
            scale = height / srcHeight;
        }
        if (width > 0 && height > 0) {
            scale = height / srcHeight < width / srcWidth ? height / srcHeight : width / srcWidth;
        }

        thumbnail(img, (int) (srcWidth * scale), (int) (srcHeight * scale), out);
    }

    /**
     * 按照固定宽高原图压缩
     */
    public static void thumbnail(File img, int width, int height, OutputStream out) throws IOException {
        BufferedImage bi = ImageIO.read(img);
        Image image = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.setColor(Color.RED);
        g.drawImage(image, 0, 0, null); //绘制处理后的图
        g.dispose();
        ImageIO.write(tag, "JPG", out);
    }

    public static void main(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out = new ByteArrayOutputStream();
        //jpg
        ImageIO.write(image, "jpg", out);
    }


}

