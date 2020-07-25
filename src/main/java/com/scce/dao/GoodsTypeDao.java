package com.scce.dao;

import com.scce.pojo.GoodsType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsTypeDao {
    //查询所有商品种类数量
    @Select("SELECT COUNT(1) FROM goods WHERE goodsTypeId=#{goodsTypeId}")
    public int getAllGoodsType(int goodsTypeId);
    //查询所有商品种类名称
    @Select("SELECT*FROM  goodstype")
    public List<GoodsType> AllGoodsType();
    //增加商品种类名称
    public void insertGoodsType(GoodsType goodsType);
    //修改商品种类名称
    public void upGoodsType(GoodsType goodsType);
    //删除商品种类名称
    public void delGoodsType(int goodsTypeID);
}
