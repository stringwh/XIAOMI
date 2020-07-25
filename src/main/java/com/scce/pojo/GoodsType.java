package com.scce.pojo;

import java.io.Serializable;

public class GoodsType implements Serializable {
    private int goodsTypeId; //商品种类的ID
    private String goodsTypeName; //商品种类名称

    public int getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(int goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "goodsTypeId=" + goodsTypeId +
                ", goodsTypeName='" + goodsTypeName + '\'' +
                '}';
    }
}
