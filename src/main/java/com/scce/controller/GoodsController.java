package com.scce.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scce.pojo.Goods;
import com.scce.pojo.Order;
import com.scce.pojo.OrderDetail;
import com.scce.service.*;
import com.scce.utils.ExcelUtil;
import com.scce.utils.JsonResult;
import com.scce.utils.OrderNumGenerator;
import com.scce.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags="123321")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "查询所有商品信息并分页")
    @RequestMapping("/getAllGoods")
    public JsonResult getAllGoods(int pageNum, int pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        System.out.println("执行查询所有商品信息的方法");

        PageInfo<Goods> pageInfo=goodsService.getAllGoods(pageNum,pageSize);
//        for (Goods goods :pageInfo.getList()) {
//            goods.setGoodsType(goodsTypeService.getGoodsTypeById(goods.getGoodsTypeId()));
//        }
        System.out.println(pageInfo.getList());
        return new JsonResult(0,pageInfo.getList(),pageInfo.getTotal());
    }

    @ApiOperation("根据商品编号、商品名称、商品种类Id、商品价格查询商品")
    @RequestMapping("/goodNNTP")
    public JsonResult goodNNTP(@RequestParam(value = "goodsNum",required = false) String goodsNum,
                               @RequestParam(value = "goodsName",required = false) String goodsName,
                               @RequestParam(value = "goodsTypeId",required = false) Integer goodsTypeId,
                               @RequestParam(value = "goodsPrice",required = false) Float goodsPrice,
                               int pageNum, int pageSize)throws Exception{
        System.out.println("进入goodNNTP方法");
        System.out.println(goodsNum+"==="+goodsName+"==="+goodsTypeId+"==="+goodsPrice);
        PageInfo<Goods> pageInfo=goodsService.goodNNTP(goodsNum,goodsName,goodsTypeId,goodsPrice,pageNum,pageSize);
        return  new JsonResult(0, pageInfo.getList(), pageInfo.getTotal());
    }

    @ApiOperation(value = "添加商品信息   ")
    @RequestMapping("/insertGoods")
    public JsonResult insertGoods(Goods goods)throws Exception{
        System.out.println("执行添加商品的方法");
        goodsService.insertGoods(goods);
        return new JsonResult(0,"添加成功");
    }

    @ApiOperation(value = "根据商品编号修改商品")
    @RequestMapping("/updateGoods")
    public JsonResult updateGoods(Goods goods)throws Exception{
        System.out.println("执行修改商品的方法");
        goodsService.updateGoods(goods);
        return new JsonResult(0,  "修改成功");
    }

    @ApiOperation(value = "根据商品的编号修改商品状态")
    @RequestMapping("/updateStatus")
    public JsonResult updateStatus(Goods goods)throws Exception{
        goodsService.updateStatus(goods);
        return new JsonResult(0,  "修改成功");
    }

    @ApiOperation(value = "根据商品编号删除商品")
    @RequestMapping("/delGoods")
    public JsonResult delGoods(String goodsNum) throws Exception{
        System.out.println("执行删除商品的方法");
        goodsService.delGoods(goodsNum);
        return  new JsonResult(0,"删除成功");
    }

    @ApiOperation(value = "根据商品编号删除多项商品")
    @RequestMapping("/delAll")
    public JsonResult delAll(String[] gs) throws Exception{
        System.out.println("执行删除多项商品的方法");
        goodsService.delAll(gs);
        return new JsonResult(0,"删除成功");
    }

    @ApiOperation("导出表格")
    @RequestMapping("/TestExcel")
    public String TestExcel(HttpServletResponse response){
        System.out.println("进入TestExcel");
        try {
            Workbook wb = new HSSFWorkbook();  //创建工作簿
            String headers[] = {"商品编号", "商品名称", "商品种类的Id", "商品介绍信息", "商品的价格", "商品库存", "商品状态", "商品图片", "商品添加人"};
            List<Goods> list = goodsService.getAllGoods();
            System.out.println(list);
            ExcelUtil.fillExcelData(list, wb, headers);
            ResponseUtil.export(response, wb, "导出excel.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @ApiOperation(value = "根据商品的编号查询商品")
    @RequestMapping("/getOneGoods")
    public JsonResult getGoods(String goodsNum) throws Exception{
        System.out.println("执行查询方法");
        return new JsonResult(0,goodsService.getGoods(goodsNum));
    }
    @ApiOperation(value="随机单号，增加用户名称，商品总价格，下单时间，状态（未付款=0，已付款=1）订单表")
    @RequestMapping(value = "/addOrder1", method = RequestMethod.POST)
    public JsonResult addOrder(Order order,Integer customerId) {
        String orderNum = OrderNumGenerator.getOrderNum();
        while (orderService.getOneOrder(orderNum) != null) {
            orderNum = OrderNumGenerator.getOrderNum();
        }
        order.setOrderNum(orderNum);
        System.out.println();
        order.setCustomerName(customerService.selectById(customerId).getCustomerName());
        order.setOrderState(1);
        order.setOrderDate(new Date());
        int addOrder = orderService.addOrder(order);
        if (addOrder == 1) {
            return new JsonResult(orderNum);
        } else {
            return new JsonResult("添加失败");
        }
    }

    @ApiOperation(value="随机单号，商品编号，商品下单总数量")
    @RequestMapping(value="/addOrderDetail",method = RequestMethod.POST)
    public JsonResult addOrderDetail(OrderDetail orderDetail) {
        orderDetailService.addOrderDetail(orderDetail);
        return new JsonResult("订单详情添加成功");
    }

}
