package com.spring.miniproject.domain;

import java.util.Date;

public class PurchaseDto {
    private int purchase_id;
    private int product_id;
    private int user_id;
    private int total_price;
    private Date purchase_date;
    private Date payment_end_date;
    private Date delivery_date;

    public PurchaseDto() {
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Date getPayment_end_date() {
        return payment_end_date;
    }

    public void setPayment_end_date(Date payment_end_date) {
        this.payment_end_date = payment_end_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    @Override
    public String toString() {
        return "PurchaseDto{" +
                "purchase_id=" + purchase_id +
                ", product_id=" + product_id +
                ", user_id=" + user_id +
                ", total_price=" + total_price +
                ", purchase_date=" + purchase_date +
                ", payment_end_date=" + payment_end_date +
                ", delivery_date=" + delivery_date +
                '}';
    }
}
