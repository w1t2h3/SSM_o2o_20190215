package com.imooc.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.omg.CORBA.ORB;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    //        根据当前线程类加载器获取classpath的绝对路径，也就是水印的路径
    public static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    public static SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyyMMddHHmmss");
    public static Random random = new Random();
    public static void generateThumbnail(File file,String targetAddr) throws IOException {

        String realFilename = getRandomFilename();
        String extension = getExtension(file);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFilename + extension;
        Thumbnails.of(file).size(200,200)
                .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath + "/watermark.png")),0.8f)
                .outputQuality(0.8f).toFile(PathUtil.getImgBasePath() + relativeAddr);
    }

    private static void makeDirPath(String targetAddr) {
        String fileDirectory = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(fileDirectory);
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    private static String getExtension(File file) {
        String originalFilename = file.getName();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        return extension;
    }

    /**
     * 获取自定义的文件名
     * @return
     */
    private static String getRandomFilename() {
//        当天时间
        String nowTimeStr = simpleDateFormat.format(new Date());
//        随机的五位整数
        int ranString = random.nextInt(89999) + 10000;
        return nowTimeStr + ranString;
    }


    public static void main(String[] args) throws IOException {

//        Thumbnails.of(new File("D:/test_img/sun.jpg")).size(200,200)
//                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")),0.8f)
//                .outputQuality(0.8f).toFile("/test_img/sunnew.jpg");
        generateThumbnail(new File("D:/TEST/images.jpg"),"/upload/item/");
    }
}
