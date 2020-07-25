package com.scce.service;

import com.scce.pojo.Goods;
import com.scce.pojo.OrderDetail;

import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/8 18:25
 **/
public interface OrderDetailService {
    public int deleteOrderDetailByOrderNum(String orderNum);

    public List<OrderDetail> getAllDetailByNum(String orderNum);
    public List<Goods>getAllgoodsByid(int goodsId);
    public int addOrderDetail(OrderDetail orderDetail);
    //查询每个商品数量
    public int getgoodscount(int goodsId);
    //查询销售数量
    public int getgoodsxscount(int goodsId);
    //查询所有商品
    public List<Goods>getGoodsId();
    //查询商品名字
    public String getgoodsName(int goodsId);
}
