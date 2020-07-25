package com.scce.service;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.GoodsType;
import com.scce.pojo.Goodstypes;


import java.util.List;

public interface GoodsTypeService {
    //查询所有商品种类数量
    public List<Goodstypes> getAllGoodsType();
    //查询商品种类名称并分页
    public PageInfo<GoodsType> getAllGoodsType(int pageNum, int pageSize)throws Exception;
    //查询所有商品种类名称
    public List<GoodsType> getAllTypeName()throws Exception;
    //增加商品种类名称
    public void insertGoodsType(GoodsType goodsType)throws Exception;
    //修改商品种类名称
    public void upGoodsType(GoodsType goodsType)throws Exception;
    //删除商品种类名称
    public void delGoodsType(int goodsTypeId)throws Exception;

    public GoodsType getGoodsTypeById(int goodsId)throws Exception;
    //根据商品种类ID删除多项商品种类名称
    public void delAllTypename(String[] tn)throws Exception;
}
