package com.imooc.o2o.Enum;

public enum ShopStateEnum {
    CHECK(0,"审核中"),OFFLINE(-1,"非法店铺"),SUCCESS(1,"操作成功"),
        INNER_ERROR(-1001,"内部系统错误"),NULL_SHOPID(-1002,"ShopId为空"),
        NULL_SHOP(-1003,"shop信息为空");
    private int state;
    private String stateInfo;
    private ShopStateEnum(int state,String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
