package com.scce.pojo;

import java.io.Serializable;

public class Goods implements Serializable {
    private int goodsId; //商品的ID
    private String goodsNum; //商品的编号
    private String goodsName; //商品的名称
    private int goodsTypeId; //商品种类的ID(与goodstype表关联)
//    private String goodsTypeName;//商品种类名称(与goodstype表关联)
    private String goodsDescript; //关于商品的一些介绍信息
    private Float goodsPrice; //商品的价格
    private int goodsInventory; //商品库存(总数量)
    private  int goodsStatus; //商品状态（0为正常销售，1下架,2预约）
    private String goodsPic; //商品图片
    private String goodsManager; //商品添加人

    private String statusstr;//商品状态的汉字描述
    private GoodsType goodsType;//封装商品类型
    private Goods goods;

    public String getStatusstr() {//0为正常销售，1下架,2预约
        if(goodsStatus==0){
            statusstr="正常销售";
        }else if(goodsStatus==1){
            statusstr="下架";
        }else if(goodsStatus==2){
            statusstr="预约";
        }
        return statusstr;
    }

//    public String getGoodsTypeName() {
//        return goodsTypeName;
//    }

//    public void setGoodsTypeName(String goodsTypeName) {
//        this.goodsTypeName = goodsTypeName;
//    }

    public int getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(int goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public void setStatusstr(String statusstr) {
        this.statusstr = statusstr;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDescript() {
        return goodsDescript;
    }

    public void setGoodsDescript(String goodsDescript) {
        this.goodsDescript = goodsDescript;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(int goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getGoodsManager() {
        return goodsManager;
    }

    public void setGoodsManager(String goodsManager) {
        this.goodsManager = goodsManager;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsNum='" + goodsNum + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsTypeId=" + goodsTypeId +
                ", goodsDescript='" + goodsDescript + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsInventory=" + goodsInventory +
                ", goodsStatus=" + goodsStatus +
                ", goodsPic='" + goodsPic + '\'' +
                ", goodsManager='" + goodsManager + '\'' +
                ", statusstr='" + statusstr + '\'' +
                ", goodsType=" + goodsType +
                ", goods=" + goods +
                '}';
    }
}
