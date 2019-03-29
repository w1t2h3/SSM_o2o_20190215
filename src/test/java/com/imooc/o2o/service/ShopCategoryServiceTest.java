package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ShopCategoryServiceTest extends BaseTest {
    @Autowired
    private ShopCategoryService shopCategoryService;

    @Test
    public void testGetShopCategoryList() {
//        List<ShopCategory> shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
//        assertEquals(3,shopCategoryList.size());
        ShopCategory testCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(3L);
        testCategory.setParent(parentCategory);
        List<ShopCategory> shopCategoryList = shopCategoryService.getShopCategoryList(testCategory);
        assertEquals(1,shopCategoryList.size());
        System.out.println(shopCategoryList.get(0).getShopCategoryName());
    }
}