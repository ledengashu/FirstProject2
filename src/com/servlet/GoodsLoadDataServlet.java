package com.servlet;

import com.dao.GoodsDao;
import com.enity.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GoodsLoadDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errMsg = "";
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            GoodsDao goodsDao = new GoodsDao();
            Goods queryGoods = new Goods(id);
            List<Goods> list = goodsDao.findByGoods(queryGoods);
            if(list==null || list.size()<1){
                throw new RuntimeException("该商品不存在");
            }
            req.setAttribute("goods",list.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }

        if("".equals(errMsg)){
            req.getRequestDispatcher("goods_update.jsp").forward(req,resp);
        }else{
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('数据加载失败："+errMsg+"');history.back();</script>");
        }
    }
}
