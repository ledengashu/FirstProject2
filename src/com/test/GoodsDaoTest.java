package com.test;

import com.dao.GoodsDao;
import com.enity.Goods;
import com.servlet.GoodsInsertServlet;
import org.junit.Test;

import java.util.List;

public class GoodsDaoTest {
    @Test
    public void test1(){
        GoodsDao goodsDao = new GoodsDao();
        List<Goods> list = goodsDao.findByGoods(null);
        for (Goods goods : list) {
            System.out.println(goods.toString());
        }
    }

    @Test
    public void test2(){
        //int id = Integer.parseInt(req.getParameter("id"));
        GoodsDao goodsDao = new GoodsDao();
        Goods queryGoods = new Goods();
        queryGoods.setId(1);
        List<Goods> list = goodsDao.findByGoods(queryGoods);
        for (Goods goods : list) {
            System.out.println(goods);
        }
        //req.setAttribute("goods",list.get(0));
    }

    @Test
    public void test3(){
        GoodsDao goodsDao = new GoodsDao();
        Goods queryGoods = new Goods();
        queryGoods.setId(1);
        int rows = goodsDao.deleteGoods(queryGoods);
        System.out.println(rows);

    }

    @Test
    public void test4(){
        GoodsDao goodsDao = new GoodsDao();
        Goods goods = new Goods();
        goods.setGoodsInfo_name("erferw");
        goods.setGoodsInfo_pic("jhbj");
        goods.setFlag(1);
        goods.setId(18);
        goods.setGoodsInfo_price(3);
        int rows = goodsDao.updateGoods(goods);
        System.out.println(rows);
    }

    @Test
    public void test5(){

    }

}
