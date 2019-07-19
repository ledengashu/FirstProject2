package com.servlet;

import com.dao.UserDao;
import com.enity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        String errMsg = "";
        UserDao userDao = new UserDao();
        User user = new User(username,password);
        List<User> list = userDao.findByUser(user);
        try {
            if(username==null || "".equals(username)
                    || password==null || "".equals(password)){
                throw new RuntimeException("用户名和密码不能为空");
            }
            for (int i = 0; i < list.size(); i++) {
                if((username.equals(list.get(i).getUsername()))
                        && (password.equals(list.get(i).getPassword()))){
                    req.getRequestDispatcher("goodsQueryServlet").forward(req,resp);
                    break;
                }else {
                    throw new RuntimeException("用户名或密码错误");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
            out.println("<script type='text/javascript'>alert('注册失败："+errMsg+"');history.back();</script>");
        }
    }
}
