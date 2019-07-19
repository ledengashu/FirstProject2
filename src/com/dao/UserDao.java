package com.dao;

import com.enity.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/test2?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username = "root";
    private static final String password = "ashu";
    //获得连接对象
    public Connection getConnection(){
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
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

    public List<User> findByUser(User user){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            //1、获得连接对象
            conn = this.getConnection();

            //2、获得预编译语句集并执行sql语句
            StringBuffer sf = new StringBuffer();
            sf.append("select * from user where 1=1");
            List<Object> paraList = new ArrayList<>();
            if(user!=null){
                if(user.getId()!=0){
                    sf.append("and id = ?");
                    paraList.add(user.getId());
                }
            }

            //2.1、获得预编译语句
            pra = conn.prepareStatement(sf.toString());
            //2.2、设置占位符的值
            if(paraList!=null && paraList.size()>0){
                for (int i = 0; i < paraList.size(); i++) {
                    pra.setObject(i+1,paraList.get(i));
                }
            }
            //2.3、执行sql语句
            rs = pra.executeQuery();
            //2.4、遍历结果集
            while (rs.next()){
                User entity = new User();
                entity.setId(rs.getInt("id"));
                entity.setUsername(rs.getString("username"));
                entity.setPassword(rs.getString("password"));
                entity.setSex(rs.getString("sex"));
                entity.setHobbys(rs.getString("hobbys"));
                entity.setPhone(rs.getString("phone"));
                entity.setEmail(rs.getString("email"));
                entity.setAddrs(rs.getString("addrs"));
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

    public int insertUser(User user){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        List<Object> list = new ArrayList<>();

            //1、获得连接对象
            conn = this.getConnection();

            //2、获得预编译语句集并执行sql语句
            String sql = ("insert into user(username,password,sex,hobbys,phone,email,addrs,flag) values(?,?,?,?,?,?,?,?)");

            //2.2、设置占位符的值
            list.add(user.getUsername());
            list.add(user.getPassword());
            list.add(user.getSex());
            list.add(user.getHobbys());
            list.add(user.getPhone());
            list.add(user.getEmail());
            list.add(user.getAddrs());
            list.add(user.getFlag());
            return this.executeUpdate(sql,list);

    }

    //实现增删改功能
    public int executeUpdate(String sql,List<Object> list){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        try {
            //1、获得连接对象
            conn = this.getConnection();
            pra = conn.prepareStatement(sql);
            //设置占位符的值
            if(list!=null && list.size()>0){
                for (int i = 0; i < list.size(); i++) {
                    pra.setObject(i+1,list.get(i));
                }
            }
            //执行sql语句并获得受影响行数
            int rows = pra.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,pra,rs);
        }
        return 0;
    }




}