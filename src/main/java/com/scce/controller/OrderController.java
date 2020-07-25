package com.scce.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scce.pojo.Goods;
import com.scce.pojo.Order;
import com.scce.pojo.OrderDetail;
import com.scce.service.OrderDetailService;
import com.scce.service.OrderService;
import com.scce.utils.JsonResult;
import com.scce.utils.OrderNumGenerator;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/8 17:36
 **/
@RestController
@Api(tags = "OrderManage")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @ApiOperation("添加新订单")
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public JsonResult addOrder(Order order) {
        String orderNum = OrderNumGenerator.getOrderNum();
        while (orderService.getOneOrder(orderNum) != null) {
            orderNum = OrderNumGenerator.getOrderNum();
        }
        order.setOrderNum(orderNum);
        order.setOrderState(0);
        order.setOrderDate(new Date());
        if (orderService.addOrder(order) == 1) {
            return new JsonResult("添加成功,订单号为:"+orderNum);
        } else {
            return new JsonResult("添加失败");
        }
    }

    @ApiOperation("更新订单状态")
    @RequestMapping(value = "/updateOrderState", method = RequestMethod.POST)
    public JsonResult updateState(String orderNum, Integer orderState) {
        Order order = new Order();
        order.setOrderNum(orderNum);
        order.setOrderState(orderState);
        orderService.updateOrder(order);
        return new JsonResult("更新成功");
    }

    @ApiOperation("删除订单信息")
    @RequestMapping(value = "/deleteOrder",method=RequestMethod.POST)
    public JsonResult deleteOrder(String orderNum){
        System.out.println("orderNum"+orderNum);
        orderService.deleteOrder(orderNum);
        orderDetailService.deleteOrderDetailByOrderNum(orderNum);
        return new JsonResult("删除成功");
    }

    @ApiOperation("获取所有订单")
    @RequestMapping(value = "/getAllOrder",method = RequestMethod.GET)
    public JsonResult getAllOrder(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        System.out.println("执行查询所有商品信息的方法");
        PageInfo<Order> pageInfo=orderService.getAllOrder(pageNum,pageSize);
        System.out.println(pageInfo.getList().size());
        return new JsonResult(0,pageInfo.getList(),pageInfo.getTotal());
    }
    @ApiOperation("根据订单号查询")
    @RequestMapping(value = "/selectbyorderNum")
    public JsonResult selectbyorderName(String orderNum){
        System.out.println("进入订单号查询");
        //System.out.println(orderNum+"orderNum");
        PageInfo<Order> pageInfo = orderService.selectbyorderName(orderNum);

        return new JsonResult(0,pageInfo.getList(),pageInfo.getTotal());
    }
    @ApiOperation("根据客户查询")
    @RequestMapping(value = "/getorderNumbycust")
    public JsonResult getorderNumbycust(String customerName){
        System.out.println(customerName+"customerName");
        System.out.println("进入客户查询");
        List<Order> orderlist=orderService.seleorderbycyst(customerName);
        return  new JsonResult(0,orderlist);
    }
}
