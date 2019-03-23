package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {
    /**
     *  如果只需要返回一个基本类型，而不需要一个对象，可以直接使用Integert.parseInt("123");
     *
     *     如果需要一个对象，那么建议使用valueOf(),因为该方法可以借助缓存带来的好处。
     *
     *     如果和进制有关，那么就是用decode方法。
     *
     *     如果是从系统配置中取值，那么就是用getInteger
     */

    public static int getInteger(HttpServletRequest request, String key){
        try{
            return Integer.decode(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }
    public static long getLong(HttpServletRequest request,String key){
        try{
            return Long.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }

    public static double getDouble(HttpServletRequest request,String key){
        try{
            return Double.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1d;
        }
    }
    public static boolean getBoolean(HttpServletRequest request,String key){
        try{
            return Boolean.valueOf(request.getParameter(key));
        }catch (Exception e){
            return false;
        }
    }
    public static String getString(HttpServletRequest request,String key){
        try{
            String result = request.getParameter(key);
            if (result != null){
                 result = result.trim();
            }
            if ("".equals(result)){
                return null;
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }
}
