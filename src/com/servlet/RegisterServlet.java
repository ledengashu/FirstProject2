package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");
        PrintWriter out = resp.getWriter();
        if(username==null || "".equals(username) ||
                password==null || "".equals(password) ||
                confirm==null || "".equals(confirm) ){
            out.println("<script type='text/javascript'>alert('用户名、密码、确认密码不能为空');history.back();</script>");
        }else if(!password.equals(confirm)){
            out.println("<script type='text/javascript'>alert('密码和确认密码不一致');history.back();</script>");
        }else{
            out.println("<script type='text/javascript'>alert('注册成功');location.href = 'index.jsp';</script>");
            //req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
