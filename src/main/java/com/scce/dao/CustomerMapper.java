package com.scce.dao;

import com.scce.pojo.Customer;

import com.scce.pojo.Manager;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    //根据客户编号删除客户
    @Delete("delete from customer where customerId=#{customerId}")
    int deleteByPrimaryKey(Integer customerId);
    //查询所有客户
    @Select("select * from customer")
    List<Customer> selectCustomer();
    //修改客户
    @Update("UPDATE customer SET customerName=#{customerName},customerPWD=#{customerPWD},customerBirthday=#{customerBirthday},customerPhone=#{customerPhone} WHERE customerId=#{customerId}")
     void updateCustomer(Customer customer);
    //根据客户姓名查找
    @Select("select * from customer where customerName=#{customerName}")
    List<Customer> selectname(@Param("customerName") String customerName);
    //根据客户姓名查找
    @Select("select * from customer where customerName=#{customerName}")
    Customer selectOneByname(@Param("customerName") String customerName);
    //查询客户登录账号密码
    @Select(value = "select * from Customer where customerName = #{customerName} and customerPWD = #{customerPWD}")
    Customer login(@Param("customerName")String customerName, @Param("customerPWD")String customerPWD);
    //客户注册
    //增加商品
    @Insert("INSERT INTO customer(customerName,customerPWD,customerBirthday,customerPhone,customerRegDate) VALUES(#{customerName},#{customerPWD},#{customerBirthday},#{customerPhone},#{customerRegDate})")
    public void insertCustomer(Customer customer);
    //根据客户ID查找客户
    @Select("select * from customer where customerId=#{customerId}")
    Customer selectById(Integer customerId);

    //根据ID查询单个用户信息
    @Select("select * from customer where customerId=#{customer}")
    Customer selCustomer(int customer);

}