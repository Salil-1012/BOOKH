package com.example.starbucks.models;

import android.widget.ImageView;
import android.widget.TextView;

public class OrderModel
{
    int order_img,cid;
    String food_name,price,order_number;

    public OrderModel(int order_img, String food_name, String price, String order_number,int cid) {
        this.order_img = order_img;
        this.food_name = food_name;
        this.price = price;
        this.order_number = order_number;
        this.cid = cid;

    }

    public OrderModel() {

    }

    public int getOrder_img() {
        return order_img;
    }

    public void setOrder_img(int order_img) {
        this.order_img = order_img;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public int getCid(){
        return cid;
    }
    public  void setCid(int cid)
    {
        this.cid = cid;
    }
}
