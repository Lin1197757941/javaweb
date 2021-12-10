package com.example.store;

import Dao.Dao;
import bean.Goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetGoods", value = "/GetGoods")
public class GetGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sql="select * from goods";
        Dao dao=new Dao();
        List<Goods> list=dao.getSult(Goods.class,sql);

        list.forEach(System.out::println);
        HttpSession session = request.getSession();
        session.setAttribute("goods_list",list);
//        request.getRequestDispatcher("http://localhost:8080/store/goods_list.jsp").forward(request,response);
        System.out.println(list);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
