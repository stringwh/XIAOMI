package com.scce.dao;

import com.scce.pojo.Goods;
import com.scce.pojo.GoodsType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsMapper {
    //根据id查询单个商品
    @Select("select * from goods where goodsId=#{goodsId}")
    Goods selectByPrimaryKey(Integer goodsId);
    //查询所有商品信息
    @Select("select * from goods")
    @Results({
            @Result(id = true,property = "goodsId",column = "goodsId"),//id = true表示主键
            @Result(property = "goodsNum",column = "goodsNum"),
            @Result(property = "goodsName",column = "goodsName"),
            @Result(property = "goodsDescript",column = "goodsDescript"),
            @Result(property = "goodsPrice",column = "goodsPrice"),
            @Result(property = "goodsInventory",column = "goodsInventory"),
            @Result(property = "goodsStatus",column = "goodsStatus"),
            @Result(property = "goodsPic",column = "goodsPic"),
            @Result(property = "goodsManager",column = "goodsManager"),
            @Result(property = "goodsTypeId",column = "goodsTypeId"),
            //property：当前类属性，column：执行”one“操作传入的查询的数据依赖，JavaType：改属性的类型，one：查询语句
            @Result(property = "goodsType",column = "goodsTypeId",javaType = GoodsType.class,one = @One(select = "com.scce.dao.GoodstypeMapper.getTypeName"))
    })
    public List<Goods> getAllGoods();

    //根据商品编号、商品名称、商品种类Id、商品价格查询商品
    @Select({
            "<script>",
            "select * from goods",
            "<where>",
            "<if test='goodsNum!=null'>",
            "goodsNum=#{goodsNum}",
            "</if>",
            "<if test='goodsName!=null'>",
            "and goodsName=#{goodsName}",
            "</if>",
            "<if test='goodsTypeId!=null'>",
            "and goodsTypeId=#{goodsTypeId}",
            "</if>",
            "<if test='goodsPrice!=null'>",
            "goodsPrice=#{goodsPrice}",
            "</if>",
            "</where>",
            "</script>"
    })
    @Results({
            @Result(id = true,property = "goodsId",column = "goodsId"),//id = true表示主键
            @Result(property = "goodsNum",column = "goodsNum"),
            @Result(property = "goodsName",column = "goodsName"),
            @Result(property = "goodsDescript",column = "goodsDescript"),
            @Result(property = "goodsPrice",column = "goodsPrice"),
            @Result(property = "goodsInventory",column = "goodsInventory"),
            @Result(property = "goodsStatus",column = "goodsStatus"),
            @Result(property = "goodsPic",column = "goodsPic"),
            @Result(property = "goodsManager",column = "goodsManager"),
            @Result(property = "goodsTypeId",column = "goodsTypeId"),
            //property：当前类属性，column：执行”one“操作传入的查询的数据依赖，JavaType：改属性的类型，one：查询语句
            @Result(property = "goodsType",column = "goodsTypeId",javaType = GoodsType.class,one = @One(select = "com.scce.dao.GoodstypeMapper.getTypeName"))
    })
    public List<Goods> goodNNTP(@Param("goodsNum") String goodsNum, @Param("goodsName") String goodsName, @Param("goodsTypeId") Integer goodsTypeId, @Param("goodsPrice") Float goodsPrice);

    //增加商品
    @Insert("insert into goods(goodsNum,goodsName,goodsTypeId,goodsDescript,goodsPrice,goodsInventory,goodsPic,goodsManager,goodsStatus) values(#{goodsNum},#{goodsName},#{goodsTypeId},#{goodsDescript},#{goodsPrice},#{goodsInventory},#{goodsPic},#{goodsManager},#{goodsStatus})")
    public void insertGoods(Goods goods);
    //根据商品的编号查询商品
    @Select("select * from goods where goodsNum=#{goodsNum}")
    public Goods getGoods(String goodsNum);
    //根据商品编号修改商品
    @Update("update goods set goodsName=#{goodsName},goodsTypeId=#{goodsTypeId},goodsDescript=#{goodsDescript},goodsPrice=#{goodsPrice},goodsInventory=#{goodsInventory},goodsStatus=#{goodsStatus},goodsPic=#{goodsPic},goodsManager=#{goodsManager} where goodsNum=#{goodsNum}")
    public void updateGoods(Goods goods);
    //根据商品的编号修改商品状态
    @Update("update goods set goodsStatus=#{goodsStatus} where goodsNum=#{goodsNum}")
    public void updateStatus(Goods goods);
    //根据商品编号删除商品
    @Delete("delete from goods where goodsNum=#{goodsNum}")
    public void delGoods(String goodsNum);
    //根据商品编号删除多项商品
    @Delete({
            "<script>",
            "delete from goods where goodsNum in",
            "<foreach collection='array' item='goodsNum' open='(' separator=',' close=');'>",
            "#{goodsNum}",
            "</foreach>",
            "</script>"
    })
    public void delAll(String[] gs);
}
