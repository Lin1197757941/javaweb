package com.example.store;

import Dao.Dao;
import bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sql="select user_id,username,password from user_data where username=? and password=?";
        Dao dao=new Dao();
        User user= dao.getInstance(User.class,sql,username,password);
        HttpSession session = request.getSession();
//        List<User> list= dao.getSult(User.class,sql);
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i).getUser_id()+"  "+list.get(i).getUsername()+"  "+list.get(i).getPassword());
//        }
        if(username.equals(user.getUsername())&&password.equals(user.getPassword()))
        {
            session.setAttribute("username",username);
            response.sendRedirect("index.jsp");
        }

    }
}
