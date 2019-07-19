package com.servlet;

import com.dao.GoodsDao;
import com.enity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodsUpdateServlet extends HttpServlet {
    GoodsInsertServlet goodsInsertServlet = new GoodsInsertServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rows = 0;
        String errMsg = "";
        try {
//            int id = Integer.parseInt(req.getParameter("id"));
//            String goodsInfo_name = req.getParameter("goodsInfo_name");
//            String goodsInfo_pic = req.getParameter("goodsInfo_pic");
//            int goodsInfo_price = Integer.parseInt(req.getParameter("goodsInfo_price"));
//            String goodsInfo_description = req.getParameter("goodsInfo_description");
//            String goods_stock = req.getParameter("goods_stock");
//
//            if(id<0){
//                throw new RuntimeException("商品编号不能为负数");
//            }
//            if(goodsInfo_name==null || "".equals(goodsInfo_name)){
//                throw new RuntimeException("商品名称不能为空");
//            }
//            if(goodsInfo_price<=0){
//                throw new RuntimeException("商品价格不能为负数");
//            }

            Goods goods = goodsInsertServlet.uploadFile(req, resp);
            GoodsDao goodsDao = new GoodsDao();
            rows = goodsDao.updateGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }
        PrintWriter out = resp.getWriter();
        if(rows>0){
            out.println("<script type='text/javascript'>alert('修改成功');location.href='goodsQueryServlet';</script>");
        }else{
            out.println("<script type='text/javascript'>alert('修改失败："+errMsg+"');history.back();</script>");
        }

    }
}
