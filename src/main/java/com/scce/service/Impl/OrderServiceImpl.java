package com.scce.service.Impl;

import com.github.pagehelper.PageInfo;
import com.scce.dao.OrderMapper;
import com.scce.pojo.Goods;
import com.scce.pojo.Order;
import com.scce.service.OrderService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/8 17:23
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int deleteOrder(String orderNum) {
        return orderMapper.deleteOrder(orderNum);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public PageInfo<Order> getAllOrder(Integer pageNum, Integer pageSize) {
        List<Order> list= orderMapper.getAllOrder();
        PageInfo<Order> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Order getOneOrder(String orderNum) {
        return null;
    }


    @Override
    public PageInfo<Order> selectbyorderName(String orderNum) {
        List<Order> list=  orderMapper.getOneOrder(orderNum);
        PageInfo<Order> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Order> seleorderbycyst(String custname) {
        List<Order> list=orderMapper.seleorderbycus(custname);
        System.out.println(list.get(0).getOrderNum()+"...");
        return  list;
    }
}
