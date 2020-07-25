package com.scce.controller;

import com.scce.pojo.Cart;
import com.scce.service.CartService;
import com.scce.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/12 9:53
 **/
@RestController
@Api(tags = "Cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @ApiOperation("添加购物车")
    @RequestMapping(value = "/addCart",method = RequestMethod.POST)
    public JsonResult addCart(Cart cart){
        cartService.addCart(cart);
        return new JsonResult("加购成功");
    }

    @ApiOperation("删除购物车")
    @RequestMapping(value = "/delCart",method = RequestMethod.GET)
    public JsonResult delGoods(Integer cartId){
        cartService.delCart(cartId);
        return new JsonResult("购物车删除改商品成功");
    }

    @ApiOperation("查看购物车")
    @RequestMapping(value = "/getCart",method = RequestMethod.GET)
    public JsonResult getCart(Integer customerId){
        List<Cart> carts=cartService.getCartByCustomerId(customerId);
        if (carts.size()>=1){
            return new JsonResult(0,carts);
        }else {
            return new JsonResult(1,"您的购物车为空");
        }
    }

    @ApiOperation("更改购物车数量")
    @RequestMapping(value = "/updateCount",method = RequestMethod.POST)
    public JsonResult updateCount(Cart cart){
        cartService.updateGoodsCount(cart);
        return new JsonResult("数量更改成功");
    }
}
