package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

import java.util.List;

public interface ShopDao {
    /**
     * 新增shop
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

    /*
    * 查询店铺信息
    *
    * */
    List<Shop> queryByShopId(long shopId);
}
