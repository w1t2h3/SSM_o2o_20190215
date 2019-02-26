package com.imooc.o2o.util;

public class PathUtil {
    /**
     * 存放图片的根路径的前半部分
     * @return
     */
    public static String getImgBasePath(){
        String separator = System.getProperty("file.separator");
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/wang/image/";
        }else {
            basePath="/home/image/";
        }
        return basePath.replace("/",separator);
    }


}
