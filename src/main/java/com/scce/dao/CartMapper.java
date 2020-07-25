package com.scce.dao;

import com.scce.pojo.Cart;
import com.scce.pojo.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper {

    @Delete("delete from cart where cartId=#{cartId}")
    int deleteByGoodsId(Integer cartId);

    @Insert("insert into cart (customerId,goodsId,goodsCount) values(#{customerId},#{goodsId},#{goodsCount})")
    int insertCart(Cart record);


    @Update("update cart set goodsCount=#{goodsCount} where goodsId=#{goodsId} and customerId=#{customerId}")
    int updateByGoodsId(Cart cart);


    @Select("select * from cart where customerId = #{customerId}")
    @Results({
            @Result(property = "goods",column = "goodsId",javaType = Goods.class,one = @One(select = "com.scce.dao.GoodsMapper.selectByPrimaryKey"))
    })
    List<Cart> getCartByCustomer(Integer customerId);
}