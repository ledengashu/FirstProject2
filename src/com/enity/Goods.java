package com.enity;

public class Goods {
    private int id;
    private String goodsInfo_name;
    private String goodsInfo_pic;
    private int goodsInfo_price;
    private String goodsInfo_description;
    private String goods_stock;
    private int flag;

    public Goods() {
    }

    public Goods(int id) {
        this.id = id;
    }

    public Goods(int id, String goodsInfo_name, String goodsInfo_pic, int goodsInfo_price, String goodsInfo_description, String goods_stock, int flag) {
        this.id = id;
        this.goodsInfo_name = goodsInfo_name;
        this.goodsInfo_pic = goodsInfo_pic;
        this.goodsInfo_price = goodsInfo_price;
        this.goodsInfo_description = goodsInfo_description;
        this.goods_stock = goods_stock;
        this.flag = flag;
    }

    public Goods(int id, String goodsInfo_name, String goodsInfo_pic, int goodsInfo_price, String goodsInfo_description, String goods_stock) {
        this.id = id;
        this.goodsInfo_name = goodsInfo_name;
        this.goodsInfo_pic = goodsInfo_pic;
        this.goodsInfo_price = goodsInfo_price;
        this.goodsInfo_description = goodsInfo_description;
        this.goods_stock = goods_stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsInfo_name() {
        return goodsInfo_name;
    }

    public void setGoodsInfo_name(String goodsInfo_name) {
        this.goodsInfo_name = goodsInfo_name;
    }

    public String getGoodsInfo_pic() {
        return goodsInfo_pic;
    }

    public void setGoodsInfo_pic(String goodsInfo_pic) {
        this.goodsInfo_pic = goodsInfo_pic;
    }

    public int getGoodsInfo_price() {
        return goodsInfo_price;
    }

    public void setGoodsInfo_price(int goodsInfo_price) {
        this.goodsInfo_price = goodsInfo_price;
    }

    public String getGoodsInfo_description() {
        return goodsInfo_description;
    }

    public void setGoodsInfo_description(String goodsInfo_description) {
        this.goodsInfo_description = goodsInfo_description;
    }

    public String getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(String goods_stock) {
        this.goods_stock = goods_stock;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsInfo_name='" + goodsInfo_name + '\'' +
                ", goodsInfo_pic='" + goodsInfo_pic + '\'' +
                ", goodsInfo_price=" + goodsInfo_price +
                ", goodsInfo_description='" + goodsInfo_description + '\'' +
                ", goods_stock='" + goods_stock + '\'' +
                ", flag=" + flag +
                '}';
    }
}
