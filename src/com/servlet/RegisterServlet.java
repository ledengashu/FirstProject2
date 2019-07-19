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

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");
        String sex = req.getParameter("sex");
        String hobbys = req.getParameter("hobbys");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String addrs = req.getParameter("addrs");
        PrintWriter out = resp.getWriter();
        String errMsg = "";
        try {
            if(username==null || "".equals(username) ||
                    password==null || "".equals(password) ||
                    confirm==null || "".equals(confirm) ){
                throw new RuntimeException("用户名、密码、确认密码不能为空");
            }
            if(!password.equals(confirm)){
                throw new RuntimeException("密码和确认密码不一致");
            }
            UserDao userDao = new UserDao();
            User user = new User(username,password,sex,hobbys,phone,email,addrs);
            List<User> list = userDao.findByUser(user);
            for (int i = 0; i < list.size(); i++) {
                if(username.equals(list.get(i).getUsername())){
                    throw new RuntimeException("用户名已被注册");
                }
            }
            int rows = userDao.insertUser(user);
            if(rows>0) {
                out.println("<script type='text/javascript'>alert('注册成功');location.href = 'login.jsp';</script>");
            } else{
                throw new RuntimeException("注册失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
            out.println("<script type='text/javascript'>alert('注册失败："+errMsg+"');history.back();</script>");
        }
    }
}
