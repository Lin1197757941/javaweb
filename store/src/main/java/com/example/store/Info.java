package com.example.store;

import Dao.Dao;
import bean.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Info extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看商品详情
        String id = req.getParameter("id");
        Dao dao = new Dao();
        String sql = "select * from goods where goods_id=?";
        Goods goods = dao.getInstance(Goods.class, sql, Integer.parseInt(id));
        req.getSession().setAttribute("goods",goods);
        req.getRequestDispatcher("goods_info.jsp").forward(req,resp);
    }
}
