package com.dao;

import com.enity.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/test2?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "ashu";

    public Connection getConnection(){
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeAll(Connection conn, PreparedStatement pra, ResultSet rs){
        try {
            if(rs!=null) rs.close();
            if(pra!=null) pra.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Goods> findByGoods(Goods goods){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        List<Goods> list = new ArrayList<>();
        try {
            conn = this.getConnection();
            StringBuffer sf = new StringBuffer();
            sf.append(" select * from goodsInfo where 1=1 ");
            List<Object> paraList = new ArrayList<>();
            if(goods!=null){
                if(goods.getId()!=0){
                    sf.append(" and id = ? ");
                    paraList.add(goods.getId());
                }
            }
            pra = conn.prepareStatement(sf.toString());
            if(paraList!=null && paraList.size()>0){
                for (int i = 0; i < paraList.size(); i++) {
                    pra.setObject(i+1,paraList.get(i));
                }
            }
            rs = pra.executeQuery();
            while (rs.next()){
                Goods entity = new Goods();
                entity.setId(rs.getInt("id"));
                entity.setGoodsInfo_name(rs.getString("goodsInfo_name"));
                entity.setGoodsInfo_pic(rs.getString("goodsInfo_pic"));
                entity.setGoodsInfo_price(rs.getInt("goodsInfo_price"));
                entity.setGoodsInfo_description(rs.getString("goodsInfo_description"));
                entity.setGoods_stock(rs.getString("goods_stock"));
                entity.setFlag(rs.getInt("flag"));
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,pra,rs);
        }
        return list;
    }

    public int updateGoods(Goods goods){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try {
            conn = this.getConnection();
            StringBuffer sf = new StringBuffer();
            sf.append(" update goodsInfo set ");
            sf.append("     goodsInfo_name=? ");
            sf.append("     ,goodsInfo_pic=? ");
            sf.append("     ,goodsInfo_price=? ");
            sf.append("     ,goodsInfo_description=? ");
            sf.append("     ,goods_stock=? ");
            sf.append("     where id=? ");
            List<Object> paraList = new ArrayList<>();
            paraList.add(goods.getGoodsInfo_name());
            paraList.add(goods.getGoodsInfo_pic());
            paraList.add(goods.getGoodsInfo_price());
            paraList.add(goods.getGoodsInfo_description());
            paraList.add(goods.getGoods_stock());
            paraList.add(goods.getId());
            pra = conn.prepareStatement(sf.toString());
            if(paraList!=null && paraList.size()>0){
                for (int i = 0; i < paraList.size(); i++) {
                    pra.setObject(i+1,paraList.get(i));
                }
            }
            int rows = pra.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,pra,rs);
        }
        return 0;
    }

    public int deleteGoods(Goods goods){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try {
            conn = this.getConnection();
            StringBuffer sf = new StringBuffer();
            sf.append(" delete from goodsInfo ");
            sf.append(" where id=? ");
            List<Object> paraList = new ArrayList<>();
            paraList.add(goods.getId());
            pra = conn.prepareStatement(sf.toString());
            if(paraList!=null && paraList.size()>0){
                for (int i = 0; i < paraList.size(); i++) {
                    pra.setObject(i+1,paraList.get(i));
                }
            }
            int rows =pra.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,pra,rs);
        }
        return 0;
    }

    public int goodsInsert(Goods goods){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;

        try {
            conn = this.getConnection();
            String sql = " insert into goodsInfo (goodsInfo_name,goodsInfo_pic,goodsInfo_price," +
                    "goodsInfo_description,goods_stock,flag) values (?,?,?,?,?,?) ";
            List<Object> paraList = new ArrayList<>();
            paraList.add(goods.getGoodsInfo_name());
            paraList.add(goods.getGoodsInfo_pic());
            paraList.add(goods.getGoodsInfo_price());
            paraList.add(goods.getGoodsInfo_description());
            paraList.add(goods.getGoods_stock());
            paraList.add(goods.getFlag());
            pra = conn.prepareStatement(sql);
            if(paraList!=null && paraList.size()>0){
                for (int i = 0; i < paraList.size(); i++) {
                    pra.setObject(i+1,paraList.get(i));
                }
            }
            int rows = pra.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,pra,rs);
        }
        return 0;
    }
}
