package com.imooc.o2o.util;

import com.imooc.o2o.entity.Shop;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.omg.CORBA.ORB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
//    创建日志对象
    public static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    //        根据当前线程类加载器获取classpath的绝对路径，也就是水印的路径
    public static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    public static SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyyMMddHHmmss");
    public static Random random = new Random();


    /**
     * 处理图片，生成缩略图，并返回缩略图的相对路径
     * @param imageFile
     * @param shopImgPath
     * @throws IOException
     */
    public static String generateThumbnail(File imageFile,String shopImgPath){

        String randomFileName = getRandomFileName();
        String extension = getExtension(imageFile);
        makeDirPath(shopImgPath);
        String relativeAddr = shopImgPath + randomFileName + extension;
        logger.debug("current relativeAddr is: " + relativeAddr);
        String dest = PathUtil.getImgBasePath() + relativeAddr;
        logger.debug("current complete addr is: " + dest);
        try{
            Thumbnails.of(imageFile).size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath + "/watermark.png")),0.8f)
                    .outputQuality(0.8f).toFile(dest);
        }catch (IOException e){
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 自定义处理后的图片文件名
     * @return
     */
    public static String getRandomFileName() {
//        当天时间(年月日时分秒)
        String nowTimeStr = simpleDateFormat.format(new Date());
//        随机的五位正整数
        int ranString = random.nextInt(89999) + 10000;
        return nowTimeStr + ranString;
    }

    /**
     * 获取图片文件的后缀
     * @param imageFile
     * @return
     */
    private static String getExtension(File imageFile) {
        String originalFileName = imageFile.getName();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return extension;
    }

    /**
     * 创建处理后的图片文件的路径的所有目录
     * D:/wang/image/upload/item/shop/1/images.jpg ,那么该方法将创建该路径所涉及的所有目录（文件夹）
     * @param shopImgPath
     */
    private static void makeDirPath(String shopImgPath) {
        String fileDirectory = PathUtil.getImgBasePath() + shopImgPath;
        File dirPath = new File(fileDirectory);
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }
    }


    /**
     * 测试图片处理的方法
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

//        Thumbnails.of(new File("D:/test_img/sun.jpg")).size(200,200)
//                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")),0.8f)
//                .outputQuality(0.8f).toFile("/test_img/sunnew.jpg");

        Shop shop = new Shop();
        shop.setShopId(2L);
        File imageFile = new File("D:/TEST/images.jpg");
        String shopImgPath = PathUtil.getShopImgPath(shop.getShopId());
        generateThumbnail(imageFile, shopImgPath);
    }
}
