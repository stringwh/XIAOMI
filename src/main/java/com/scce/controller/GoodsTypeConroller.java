package com.scce.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scce.pojo.GoodsType;
import com.scce.service.GoodsTypeService;
import com.scce.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsTypeConroller {
    @Autowired
    private GoodsTypeService goodsTypeService;

    @ApiOperation("查询所有商品种类名称并分页")
    @RequestMapping("/getAllGoodsType")
    public JsonResult getAllGoodsType(int pageNum, int pageSize)throws Exception{
        PageHelper.startPage(pageNum,pageSize);
        System.out.println("执行查询所有商品种类名称的方法");
        PageInfo<GoodsType> pageInfo=goodsTypeService.getAllGoodsType(pageNum,pageSize);
        System.out.println(pageInfo.getList());
        return new JsonResult(0,pageInfo.getList(),pageInfo.getTotal());
    }

    @ApiOperation("增加商品种类名称")
    @RequestMapping("/insertGoodsType")
    public JsonResult insertGoodsType(GoodsType goodsType)throws Exception{
        System.out.println("执行添加商品的方法");
        goodsTypeService.insertGoodsType(goodsType);
        return new JsonResult(0,"添加成功");
    }

    @ApiOperation(value = "查询所有商品种类名称")
    @RequestMapping(value = "/getAllTypeName",method = RequestMethod.GET)
    public JsonResult getAllTypeName()throws Exception{
        System.out.println("执行查询所有商品种类名称的方法");
        List<GoodsType> list=goodsTypeService.getAllTypeName();
        return new JsonResult(0,list);
    }

    @ApiOperation("修改商品种类名称")
    @RequestMapping("/upGoodsType")
    public JsonResult upGoodsType(GoodsType goodsType) throws Exception{
        System.out.println("执行修改商品种类名称");
        goodsTypeService.upGoodsType(goodsType);
        return new JsonResult(0,"修改成功");
    }
    @ApiOperation("删除商品种类名称")
    @RequestMapping("/delGoodsType")
    public JsonResult delGoodsType(int goodsTypeId) throws Exception{
        System.out.println("执行删除商品信息");
        goodsTypeService.delGoodsType(goodsTypeId);
        return new JsonResult(0,"删除成功");
    }

    @ApiOperation("根据商品种类ID删除多项商品种类名称")
    @RequestMapping("/delAllTypename")
    public JsonResult delAllTypename(String[] tn) throws Exception{
        System.out.println("执行删除多项商品种类名称的方法");
        goodsTypeService.delAllTypename(tn);
        return new JsonResult(0,"删除成功");
    }
}
