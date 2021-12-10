package com.example.store;

import Dao.Dao;
import bean.Goods;
import bean.Orders;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

public class AddOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goods_id = request.getParameter("id");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Dao dao=new Dao();
        //查询是否已有该商品的订单
        String sql="select * from orders where goods_id=? and username=?";
        Orders instance = dao.getInstance(Orders.class, sql, Integer.parseInt(goods_id), username);
        //查询该商品库存
        String sql_goods="select * from goods where goods_id=?";
        Goods goods = dao.getInstance(Goods.class, sql_goods, Integer.parseInt(goods_id));

        if(goods.getStock()>0) {
            if (instance == null) {

                String sql1 = "insert into orders(goods_id,goods_name,username,price,order_num) values(?,?,?,?,?)";

                Dao.updata(sql1, goods.getGoods_id(), goods.getGoods_name(), username, goods.getPrice(),1);
            } else {
                String sql2 = "update orders set order_num=? where goods_id=? and username=?";
                int num = instance.getOrder_num() + 1;
                Dao.updata(sql2, num,instance.getGoods_id(),username);
            }
            int n=goods.getStock()-1;
            String sql3="update goods set stock=? where goods_id=?";
            Dao.updata(sql3,n,goods.getGoods_id());
        }
        else
        {
            request.setAttribute("msg","库存不足！添加失败！");
        }
        request.getRequestDispatcher("info?id="+goods.getGoods_id()).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
