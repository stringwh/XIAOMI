package com.scce.dao;

import com.scce.pojo.Goods;
import com.scce.pojo.OrderDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/8 16:50
 **/
@Repository
public interface OrderDetailMapper {
//
//    private String orderNum;
//    private int goodsId;
//    private int goodsCount;


    @Select("select * from orderdetail where orderNum=#{orderNum}")
    @Results({
            @Result(property = "goodsId", column = "goodsId"),
            @Result(property = "goodsCount", column = "goodsCount"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "goods", column = "goodsId", javaType = Goods.class, one = @One(select = "com.scce.dao.GoodsMapper.selectByPrimaryKey"))
    })
    List<OrderDetail> getOrderDetailByOrderNum(String orderNum);

//    @Update("update orderdetail set goodsCount=#{goodsCount} where orderNum=#{orderNum}")
//    int updateOrderDetail(OrderDetail orderDetail);

    @Delete("delete from orderdetail where orderNum=#{orderNum}")
    int deleteOrderDetail(String orderNum);


    @Insert("insert into orderdetail values(#{orderNum},#{goodsId},#{goodsCount})")
    int addOrderDetail(OrderDetail orderDetail);

    @Select("select * from goods where goodsId=#{goodsId}")
    List<Goods> getAllgoodsByid(int goodsId);

    //查询每个商品数量
    @Select("select goodsInventory from goods where goodsId=#{goodsId}")
    int getgoodscount(int goodsId);
    //查询每个商品销售数量
    @Select("select sum(goodsCount) from orderdetail where goodsId=#{goodsId}")
    int getgoodsxscount(int goodsId);
    //查询商品id
    @Select("select * from goods")
    public List<Goods> getGoodsId();
    //查询商品名字
    @Select("select goodsName from goods where goodsId=#{goodsId}")
    String getgoodsName(int goodsId);

}
