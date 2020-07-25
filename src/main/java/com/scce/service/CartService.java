package com.scce.service;

import com.scce.pojo.Cart;

import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/12 9:35
 **/
public interface CartService {
    List<Cart> getCartByCustomerId(Integer customerId);

    int updateGoodsCount(Cart cart);

    int addCart(Cart cart);

    int delCart(Integer cartId);

}
