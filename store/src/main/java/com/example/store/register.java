package com.example.store;

import Dao.Dao;
import Util.JDBCUtils;
import bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class register extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sq="select username from user_data where username=?";
        Dao dao=new Dao();
        User instance = dao.getInstance(User.class, sq, username);
        if(instance==null){
            String sql="insert into user_data(username,password) values(?,?)";
            Dao.updata(sql,username,password);
            response.sendRedirect("index.jsp");
        }
        else {
            request.setAttribute("remsg","该用户名已注册!请重新注册");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }

    }
}
