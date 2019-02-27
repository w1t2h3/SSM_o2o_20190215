package com.imooc.o2o.dto;

import com.imooc.o2o.Enum.ShopStateEnum;
import com.imooc.o2o.entity.Shop;

import java.util.List;

public class ShopExecution {
    private int state;
    private String stutusInfo;
    private Shop shop;
    private List<Shop> shopList;

    public ShopExecution(){}

//    店铺操作失败时使用的构造器
    public ShopExecution(ShopStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stutusInfo = stateEnum.getStateInfo();
    }
    //    店铺操作成功时使用的构造器
    public ShopExecution(ShopStateEnum stateEnum, Shop shop){
        this.state = stateEnum.getState();
        this.stutusInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }
    //    店铺操作成功时使用的构造器
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList){
        this.state = stateEnum.getState();
        this.stutusInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStutusInfo() {
        return stutusInfo;
    }

    public void setStutusInfo(String stutusInfo) {
        this.stutusInfo = stutusInfo;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
