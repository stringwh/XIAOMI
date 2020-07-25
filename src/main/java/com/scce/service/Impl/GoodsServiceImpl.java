package com.scce.service.Impl;

import com.github.pagehelper.PageInfo;
import com.scce.dao.GoodsMapper;
import com.scce.pojo.Goods;
import com.scce.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    //查询所有商品信息并分页
    public PageInfo<Goods> getAllGoods(int pageNum, int pageSize) throws Exception {
        List<Goods> list=goodsMapper.getAllGoods();
        PageInfo<Goods> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
    //根据商品的编号查询商品
    public Goods getGoods(String goodsNum) throws Exception {
        Goods goods=goodsMapper.getGoods(goodsNum);
        return goods;
    }

    //根据商品编号、商品名称、商品种类Id、商品价格查询商品
    public PageInfo<Goods> goodNNTP(String goodsNum, String goodsName, Integer goodsTypeId, Float goodsPrice,int pageNum, int pageSize) throws Exception {
        PageInfo<Goods> pageInfo=null;
        try{
            List<Goods> list=goodsMapper.goodNNTP(goodsNum,goodsName,goodsTypeId,goodsPrice);
            pageInfo=new PageInfo<>(list);
            System.out.println("Service方法中："+pageInfo.getList());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }

    //增加商品
    public void insertGoods(Goods goods) throws Exception {
        goodsMapper.insertGoods(goods);
    }

    //根据商品编号修改商品
    public void updateGoods(Goods goods) throws Exception {
        goodsMapper.updateGoods(goods);
    }

    //根据商品的编号修改商品状态
    public void updateStatus(Goods goods) throws Exception {
        goodsMapper.updateStatus(goods);
    }

    //根据商品编号删除商品
    public void delGoods(String goodsNum) throws Exception {
        try{
            goodsMapper.delGoods(goodsNum);
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    //根据商品编号删除多项商品
    public void delAll(String[] gs) throws Exception {
        try{
            goodsMapper.delAll(gs);
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    //Excel表格
    public List<Goods> getAllGoods() throws Exception {
        List<Goods> list=goodsMapper.getAllGoods();
        return list;
    }


}
