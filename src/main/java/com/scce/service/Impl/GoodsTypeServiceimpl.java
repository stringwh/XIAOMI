package com.scce.service.Impl;

import com.github.pagehelper.PageInfo;
import com.scce.dao.GoodsTypeDao;


import com.scce.dao.GoodstypeMapper;
import com.scce.pojo.GoodsType;
import com.scce.pojo.Goodstypes;
import com.scce.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GoodsTypeServiceimpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeDao goodsTypeDao;
    @Autowired
    private GoodstypeMapper goodstypeMapper;



    //饼状图
    @Override
    public List<Goodstypes> getAllGoodsType() {
        List<Goodstypes> list=new ArrayList<Goodstypes>();
        List<GoodsType> list1= goodsTypeDao.AllGoodsType();
        System.out.println(list1);

        for (GoodsType goodsType : list1) {
            Goodstypes goodstypes=new Goodstypes();
            int allGoodsType = goodsTypeDao.getAllGoodsType(goodsType.getGoodsTypeId());
            System.out.println(allGoodsType);
            goodstypes.setId(allGoodsType);
            goodstypes.setName(goodsType.getGoodsTypeName());
            list.add(goodstypes);
        }
        return list;
    }
    //查询所有商品种类名称并分页
    public PageInfo<GoodsType> getAllGoodsType(int pageNum, int pageSize) throws Exception {
        List<GoodsType> list=goodstypeMapper.getAllGoodsType();
        PageInfo<GoodsType> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
    //查询所有商品种类名称
    public List<GoodsType> getAllTypeName() throws Exception {
        List<GoodsType> list=goodstypeMapper.getAllGoodsType();
        System.out.println(list+"list");
        return list;
    }
    //增加商品种类名称
    public void insertGoodsType(GoodsType goodsType) throws Exception {
        goodstypeMapper.insertGoodsType(goodsType);
    }

    //修改商品种类名称
    public void upGoodsType(GoodsType goodsType) throws Exception {
        goodstypeMapper.upGoodsType(goodsType);
    }

    //删除商品种类名称
    public void delGoodsType(int goodsTypeId) throws Exception {
        try {
            goodstypeMapper.delGoodsType(goodsTypeId);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }



    @Override
    public GoodsType getGoodsTypeById(int goodsId) {
        return goodstypeMapper.getTypeName(goodsId);
    }

    //根据商品种类ID删除多项商品种类名称
    public void delAllTypename(String[] tn) throws Exception {
        try {
            goodstypeMapper.delAllTypename(tn);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
