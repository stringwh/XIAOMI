package com.scce.dao;

import com.scce.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(String orderNum);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderNum);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    @Insert("insert into `order` values(#{orderNum},#{customerName},#{totalMoney},#{orderDate},#{orderState})")
    int addOrder(Order order);

    @Delete("delete from `order` where orderNum=#{orderNum}")
    int deleteOrder(String orderNum);

    @Update("update `order` set orderState=#{orderState} where orderNum = #{orderNum}")
    int updateOrder(Order order);


    @Select("select * from `order`")
    List<Order> getAllOrder();

    @Select("select * from `order` where orderNum = #{orderNum}")
    List<Order> getOneOrder(String orderNum);
    @Select("select * from `order` where customerName = #{custname}")
    List<Order>seleorderbycus(String custname);




}