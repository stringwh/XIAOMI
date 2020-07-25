package com.scce.service.Impl;

import com.scce.dao.OrderDetailMapper;
import com.scce.pojo.Goods;
import com.scce.pojo.OrderDetail;
import com.scce.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/8 18:26
 **/
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public int deleteOrderDetailByOrderNum(String orderNum) {
        return orderDetailMapper.deleteOrderDetail(orderNum);
    }

    @Override
    public List<OrderDetail> getAllDetailByNum(String orderNum) {
        return orderDetailMapper.getOrderDetailByOrderNum(orderNum);
    }

    @Override
    public List<Goods> getAllgoodsByid(int goodsId) {

        return orderDetailMapper.getAllgoodsByid(goodsId);
    }

    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.addOrderDetail(orderDetail);
    }


    @Override
    public int getgoodscount(int goodsId) {
        int goodscount=orderDetailMapper.getgoodscount(goodsId);

        return goodscount;
    }

    @Override
    public int getgoodsxscount(int goodsId) {
        int goodsxscount=0;
        try {
            goodsxscount= orderDetailMapper.getgoodsxscount(goodsId);

        }catch (Exception e) {
        }
        return goodsxscount;
    }

    @Override
    public List<Goods> getGoodsId() {
        List<Goods> goodsList=orderDetailMapper.getGoodsId();
        return  goodsList;
    }
    public String getgoodsName(int goodId){
        return orderDetailMapper.getgoodsName(goodId);
    }
}
