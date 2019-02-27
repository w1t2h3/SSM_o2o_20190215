package com.imooc.o2o.service;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.io.File;

public interface ShopService {
    ShopExecution addShop(Shop shop, File shopImg);
}
