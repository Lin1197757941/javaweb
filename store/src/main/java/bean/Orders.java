package bean;

import java.sql.Time;
import java.sql.Timestamp;

public class Orders {
    private int order_id;
    private int goods_id;
    private String goods_name;
    private String username;
    private Timestamp order_time;
    private int order_num;
    private double price;
    public Orders(){ }
    public Orders(int order_id, int goods_id, String goods_name, String username, Timestamp order_time, int order_num,double price){
        this.order_id=order_id;
        this.goods_id=goods_id;
        this.goods_name=goods_name;
        this.username=username;
        this.order_time=order_time;
        this.order_num=order_num;
        this.price=price;
    }
    public int getOrder_id(){
        return order_id;
    }
    public int getGoods_id(){
        return goods_id;
    }
    public String getGoods_name(){
        return goods_name;
    }
    public String getUsername(){
        return username;
    }
    public Timestamp getOrder_time(){
        return order_time;
    }
    public int getOrder_num(){
        return order_num;
    }
    public double getPrice(){return price;}
    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", username='" + username + '\'' +
                ", order_time=" + order_time +
                ", order_num=" + order_num +
                ",},price="+price;
    }
}
