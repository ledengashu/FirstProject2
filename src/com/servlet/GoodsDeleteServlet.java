package com.servlet;

import com.dao.GoodsDao;
import com.enity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodsDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //int id = Integer.parseInt(req.getParameter("id"));
        int id;
        String good_id = req.getParameter("id");
        int rows = 0;
        String errMsg = "";
        try {
            if(good_id==null){
                throw new RuntimeException("找不到该商品");
            }else{
                id = Integer.parseInt(good_id);
            }
            Goods goods = new Goods(id);
            GoodsDao goodsDao = new GoodsDao();
            rows = goodsDao.deleteGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }
        PrintWriter out = resp.getWriter();
        if(rows>0){
            out.println("<script type='text/javascript'>alert('删除成功');location.href='goodsQueryServlet';</script>");
        }else{
            out.println("<script type='text/javascript'>alert('删除失败："+errMsg+"');history.back();</script>");
        }
    }
}
