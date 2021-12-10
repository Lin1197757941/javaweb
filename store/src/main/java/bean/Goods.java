package bean;

public class Goods {
    private int goods_id;
    private String goods_name;
    private double price;
    private int stock;
    public Goods(){}
    public Goods(int goods_id, String goods_name, double price, int stock){
        this.goods_id=goods_id;
        this.goods_name=goods_name;
        this.price=price;
        this.stock=stock;
    }
    public int getGoods_id(){
        return goods_id;
    }
    public String getGoods_name(){
        return goods_name;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
