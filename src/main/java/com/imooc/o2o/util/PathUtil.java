package com.imooc.o2o.util;

import java.io.File;

public class PathUtil {
//    获取系统文件路径的分隔符
    public static String separator = System.getProperty("file.separator");
    /**
     * 存放图片的路径的前半部分
     * @return
     */
    public static String getImgBasePath(){
//      获取操作系统名称
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/wang/image";
        }else {
            basePath="/home/image";
        }
        return basePath.replace("/",separator);
    }

    /**
     * 存放图片的路径的后半部分
     * @param shopId
     * @return
     */
    public static String getShopImgPath(Long shopId){
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/",separator);
    }


    public static void deleteFileOrPath(String storePath){
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()){
            if (fileOrPath.isDirectory()){
                File[] files = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }
}
