package com.scce.pojo;

public class xstxt {
    //商品名称
    private String goodsName;
    //商品库存
    private int goodsInventory;
    //商品销售数量
    private int goodsxscount;
    //商品编号
    private int goodsId;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(int goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public int getGoodsxscount() {
        return goodsxscount;
    }

    public void setGoodsxscount(int goodsxscount) {
        this.goodsxscount = goodsxscount;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "xstxt{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsInventory=" + goodsInventory +
                ", goodsxscount=" + goodsxscount +
                ", goodsId=" + goodsId +
                '}';
    }
}
