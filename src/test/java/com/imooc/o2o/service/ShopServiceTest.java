package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.Enum.ShopStateEnum;
import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.*;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws FileNotFoundException {
        Area area = new Area();
        PersonInfo owner = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        area.setAreaId(2);
        owner.setUserId(1L);
        shopCategory.setShopCategoryId(1L);
        Shop shop = new Shop();
        shop.setArea(area);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺3");
        shop.setShopDesc("test3");
        shop.setShopAddr("test3");
        shop.setPhone("test3");
        shop.setPriority(1);
        shop.setAdvice("审核中");

        File imageFile = new File("D:/TEST/images.jpg");
        InputStream is = new FileInputStream(imageFile);
        ShopExecution shopExecution = shopService.addShop(shop,is,imageFile.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),shopExecution.getState());

    }

    @Test
    public void testModifyShop() throws FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改后店铺的名称");
        File file = new File("C:\\Users\\wang\\Desktop\\juren.jpg");
        InputStream shopImgInputStream = new FileInputStream(file);
        ShopExecution shopExecution = shopService.modifyShop(shop, shopImgInputStream, "newjuren.jpg");
        System.out.println(shop.getShopName());
        System.out.println(shop.getShopImg());

    }
}