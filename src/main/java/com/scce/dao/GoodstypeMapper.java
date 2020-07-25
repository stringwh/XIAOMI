package com.scce.dao;

import com.scce.pojo.GoodsType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodstypeMapper {
    //查询所有商品种类名称
    @Select("select * from goodstype")
    public List<GoodsType> getAllGoodsType();
    //根据商品种类的ID查询商品种类名称
    @Select("select * from goodstype where goodsTypeId=#{goodsTypeId}")
    public GoodsType getTypeName(int goodsTypeId);
    //增加商品种类名称
    @Insert("insert into goodstype(goodsTypeName) values(#{goodsTypeName})")
    public void insertGoodsType(GoodsType goodsType);
    //修改商品种类名称
    @Update("update goodstype set goodsTypeName=#{goodsTypeName} where goodsTypeId=#{goodsTypeId}")
    public void upGoodsType(GoodsType goodsType);
    //删除商品种类名称
    @Delete("delete from goodstype where goodsTypeId=#{goodsTypeId}")
    public void delGoodsType(int goodsTypeId);
    //根据商品种类ID删除多项商品种类名称
    @Delete({
            "<script>",
            "delete from goodstype where goodsTypeId in",
            "<foreach collection='array' item='goodsTypeId' open='(' separator=',' close=');'>",
            "#{goodsTypeId}",
            "</foreach>",
            "</script>"
    })
    public void delAllTypename(String[] tn);
}
