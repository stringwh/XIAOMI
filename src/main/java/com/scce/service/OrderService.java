package com.scce.service;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/8 17:21
 **/
public interface OrderService {

    public int addOrder(Order order);

    public int deleteOrder(String orderNum);

    public int updateOrder(Order order);

    public PageInfo<Order> getAllOrder(Integer pageNum, Integer pageSize);

    public Order getOneOrder(String orderNum);
    PageInfo<Order> selectbyorderName(String orderNum);
    public List<Order>seleorderbycyst(String custname);
}
