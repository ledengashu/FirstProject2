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
            if(conn!=null) conn.close();
            if(pra!=null) pra.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> insertByUser(User user){
        Connection conn = null;
        PreparedStatement pra = null;
        ResultSet rs = null;
        List<Object> list = new ArrayList<>();

        try {
            //1、获得连接对象
            conn = this.getConnection();

            //2、获得预编译语句集并执行sql语句
            StringBuffer sf = new StringBuffer();
            String sql = ("insert into user(username,password,sex,hobbys,phone" +
                    "email,addrs,flag) values(?,?,?,?,?,?,?,?)");

            //2.1、获得预编译语句
            pra = conn.prepareStatement(sql);

            //2.2、设置占位符的值
            list.add(user.getUsername());
            list.add(user.getPassword());
            list.add(user.getSex());
            list.add(user.getHobbys());
            list.add(user.getPhone());
            list.add(user.getEmail());
            list.add(user.getAddrs());
            list.add(user.getFlag());
            for (int i = 0; i < list.size(); i++) {
                pra.setObject(i+1,list.get(i));
            }

            //2.3、执行sql语句
            rs = pra.executeQuery();
            while(rs.next()){
                User entity = new User();
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

            //2.4、遍历结果集
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //3、关闭资源
            closeAll(conn,pra,rs);
        }
        return null;
    }




}