package com.scce.controller;

import com.scce.pojo.Goodstypes;
import com.scce.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
    @RestController
    public class VCSController {
        @Autowired
        private GoodsTypeService goodsTypeService;
        //饼状图 商品类型数量图
        @RequestMapping("/getGoodsType")
        public List<Goodstypes> getGoodsType() {
            System.out.println("进入getGoodsType方法");
            List<Goodstypes> list= goodsTypeService.getAllGoodsType();
            System.out.println(list);
            return list;
        }
}
