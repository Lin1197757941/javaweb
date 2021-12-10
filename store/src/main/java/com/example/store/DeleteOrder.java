package com.example.store;

import Dao.Dao;
import bean.Goods;
import bean.Orders;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        System.out.println(username);
        String id=req.getParameter("id");//该商品编号
        System.out.println(id);
        Dao dao=new Dao();
        //查询该商品的订单
        String sql1="select * from orders where username=? and goods_id=?";
        Orders order = dao.getInstance(Orders.class, sql1, username, Integer.parseInt(id));
        int order_num=order.getOrder_num();
        //从订单表删除该商品订单
        String sql2="delete from orders where username=? and goods_id=?";
        Dao.updata(sql2,username,Integer.parseInt(id));
        //获取该商品库存
        String sql3="select stock from goods where goods_id=?";
        Goods goods = dao.getInstance(Goods.class, sql3, Integer.parseInt(id));
        int stock=goods.getStock()+order_num;
        //更新该商品库存
        String sql4="update goods set stock=? where goods_id=?";
        Dao.updata(sql4,stock,Integer.parseInt(id));
        req.getRequestDispatcher("user_data.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

