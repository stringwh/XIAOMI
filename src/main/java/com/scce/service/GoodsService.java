package com.scce.service;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.Goods;

import java.util.List;

public interface GoodsService {
    //查询所有商品信息
    public PageInfo<Goods> getAllGoods(int pageNum, int pageSize)throws Exception;
    //根据商品的编号查询商品
    public Goods getGoods(String goodsNum)throws Exception;
    //根据商品编号、商品名称、商品种类Id、商品价格查询商品
    public PageInfo<Goods> goodNNTP(String goodsNum, String goodsName, Integer goodsTypeId, Float goodsPrice, int pageNum, int pageSize)throws Exception;
    //增加商品
    public void insertGoods(Goods goods)throws Exception;
    //根据商品编号修改商品
    public void updateGoods(Goods goods)throws Exception;
    //根据商品的编号修改商品状态
    public void updateStatus(Goods goods)throws Exception;
    //根据商品编号删除商品
    public void delGoods(String goodsNum)throws Exception;
    //根据商品编号删除多项商品
    public void delAll(String[] gs)throws Exception;
    //Excel表格
    public List<Goods> getAllGoods()throws Exception;
}
