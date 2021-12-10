package com.example.store;//package com;

import Dao.Dao;
import bean.Orders;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.internet.*;
import javax.mail.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail")
public class Payment extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String email = request.getParameter("email");

        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
        props.put("mail.smtp.port", "25");
        // 此处填写你的账号
        props.put("mail.user","1197757941@qq.com");
        // 此处的密码就是前面说的16位STMP口令
        props.put("mail.password","uotsmnsnjchcjfha");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form;
        try {
            form = new InternetAddress(
                    props.getProperty("mail.user"));

            message.setFrom(form);


            // 设置收件人的邮箱
            InternetAddress to = new InternetAddress(email);
            message.setRecipient(Message.RecipientType.TO, to);

            // 设置邮件标题
            message.setSubject("订单支付成功");

            // 设置邮件的内容体
            message.setContent("尊敬的客户，您购买的商品已支付成功", "text/html;charset=UTF-8");

            // 最后当然就是发送邮件啦
            Transport.send(message);
            List<Orders> ordersList = (List<Orders>) request.getSession().getAttribute("ordersList");
            Date date=new Date();
            Timestamp order_time=new Timestamp(date.getTime());
            String sql="insert into list() values(?,?,?,?,?,?,?)";
            for(Orders order:ordersList){

                Dao.updata(sql,null,order.getGoods_id(),order.getGoods_name(),order.getUsername(),order_time,order.getOrder_num(),order.getPrice());
            }
            String sql2="delete from orders where username=?";
            Dao.updata(sql2,ordersList.get(0).getUsername());
            response.sendRedirect(request.getContextPath()+"/user_data.jsp");
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}