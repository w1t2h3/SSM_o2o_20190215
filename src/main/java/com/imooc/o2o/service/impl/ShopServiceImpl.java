package com.imooc.o2o.service.impl;

import com.imooc.o2o.Enum.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.ImageUtil;
import com.imooc.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
//    下面的注解是事务管理，一旦RuntimeException异常，就事务回滚
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream imageFileInputStream,String fileName) {
//        空值判断
        if (shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
//            给店铺信息赋初始值
            shop.setEnableStatus(ShopStateEnum.CHECK.getState());
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
//            添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0){
                throw new ShopOperationException("店铺创建失败");
            }else {
                if (imageFileInputStream != null) {
                    try {
//                   存储图片
                        addShopImg(shop, imageFileInputStream,fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error: " + e.getMessage());
                    }
//                    更新店铺的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0){
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        }catch (Exception e){
            throw new ShopOperationException("addShop error: " + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream imageFileInputStream,String fileName) {
//        获取将要存放缩略图的路径的后半部分
        String shopImgPath = PathUtil.getShopImgPath(shop.getShopId());
//        生成缩略图，并存放到全路径下，返回路径的后半部分（包括文件名和后缀）
        String shopImgAddr = ImageUtil.generateThumbnail(imageFileInputStream,fileName,shopImgPath);
        shop.setShopImg(shopImgAddr);

    }

}
