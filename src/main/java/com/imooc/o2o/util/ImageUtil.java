package com.imooc.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    public static void main(String[] args) throws IOException {
//        根据当前线程类加载器获取classpath的绝对路径，也就是水印的路径
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Thumbnails.of(new File("D:/test_img/sun.jpg")).size(200,200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")),0.8f)
                .outputQuality(0.8f).toFile("/test_img/sunnew.jpg");
    }
}
