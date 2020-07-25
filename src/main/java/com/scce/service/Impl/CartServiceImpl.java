package com.scce.service.Impl;

import com.scce.dao.CartMapper;
import com.scce.pojo.Cart;
import com.scce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/12 9:35
 **/
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> getCartByCustomerId(Integer customerId) {
        return  cartMapper.getCartByCustomer(customerId);
    }

    @Override
    public int updateGoodsCount(Cart cart) {
        return cartMapper.updateByGoodsId(cart);
    }

    @Override
    public int addCart(Cart cart) {
        return cartMapper.insertCart(cart);
    }

    @Override
    public int delCart(Integer cartId) {
        return cartMapper.deleteByGoodsId(cartId);
    }
}
