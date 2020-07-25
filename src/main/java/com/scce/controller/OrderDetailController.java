package com.scce.controller;

import com.scce.pojo.Goods;
import com.scce.pojo.Order;
import com.scce.pojo.OrderDetail;
import com.scce.service.OrderDetailService;
import com.scce.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;
import com.scce.pojo.xstxt;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/8 18:50
 **/
@RestController
@Api(tags = "OrderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @ApiOperation("getOrderDetail")
    @RequestMapping(value = "/getOrderDetail",method = RequestMethod.GET)
    public JsonResult getOrderDetailByOrderNum(String orderNum){
        System.out.println("¥getOrderDetail");
        List<OrderDetail> orderDetails=orderDetailService.getAllDetailByNum(orderNum);
        return new JsonResult(0,orderDetails);
    }
    @ApiOperation("getgoodsidbyorder")
    @RequestMapping(value="/getgoodsidbyorder")
    public JsonResult getgoodsidbyorder(String orderNum){
        System.out.println("进入orderNum"+orderNum);
        List<OrderDetail> orderDetails=orderDetailService.getAllDetailByNum(orderNum);
        int goodsid=orderDetails.get(0).getGoodsId();
        int goodscount=orderDetails.get(0).getGoodsCount();
        System.out.println("goodsid"+goodsid+" "+"goodscount"+goodscount);
        List<Goods>goodsList=orderDetailService.getAllgoodsByid(goodsid);
        return  new JsonResult(goodscount,goodsList);
    }
    //根据商品显示总数和销售的数量

    @ApiOperation("gettxt")
    @RequestMapping(value = "/gettxt")
    public List<xstxt> gettxt1()
    {
        //存放条形图
        List<xstxt> list = new ArrayList<xstxt>();//查询所有商品号
        List<Goods> goodsidList = orderDetailService.getGoodsId();
        //遍历商品
        for (Goods goods : goodsidList) {
            System.out.println("商品id"+goods.getGoodsId());
            //根据商品查询数量
            String goodsName=orderDetailService.getgoodsName(goods.getGoodsId());
            System.out.println("商品名字"+goodsName);
            int goodsInventory = orderDetailService.getgoodscount(goods.getGoodsId());
            //根据商品号查询已出售的
            int goodsxscount = orderDetailService.getgoodsxscount(goods.getGoodsId());
            System.out.println("出售"+goodsxscount);
            System.out.println("库存"+goodsInventory);
            xstxt xs = new xstxt();
            xs.setGoodsxscount(goodsxscount);
            xs.setGoodsInventory(goodsInventory);
            xs.setGoodsName(goodsName);
            xs.setGoodsId(goods.getGoodsId());
            list.add(xs);
        }
        return list;
    }

}
