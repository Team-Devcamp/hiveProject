package com.spring.miniproject.domain;


import java.util.Date;

public class UserPurchaseDto {
    private Integer purchase_id;
    private Integer product_id;
    private Integer user_id;
    private Date purchase_date;
    private Integer total_price;
    private Date payment_end_date;
    private Date delivery_date;
    private String product_thumb_nail;
    private String product_title;

    public UserPurchaseDto(Integer purchase_id, Integer product_id, Integer user_id, Date purchase_date,
                           Integer total_price, Date payment_end_date, Date delivery_date, String product_thumb_nail,String product_title) {
        this.purchase_id = purchase_id;
        this.product_id = product_id;
        this.user_id = user_id;
        this.purchase_date = purchase_date;
        this.total_price = total_price;
        this.payment_end_date = payment_end_date;
        this.delivery_date = delivery_date;
        this.product_thumb_nail = product_thumb_nail;
        this.product_title = product_title;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public Integer getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Integer purchase_id) {
        this.purchase_id = purchase_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
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

    public String getProduct_thumb_nail() {
        return product_thumb_nail;
    }

    public void setProduct_thumb_nail(String product_thumb_nail) {
        this.product_thumb_nail = product_thumb_nail;
    }

    @Override
    public String toString() {
        return "UserPurchaseDto{" +
                "purchase_id=" + purchase_id +
                ", product_id=" + product_id +
                ", user_id=" + user_id +
                ", purchase_date=" + purchase_date +
                ", total_price=" + total_price +
                ", payment_end_date=" + payment_end_date +
                ", delivery_date=" + delivery_date +
                ", product_thumb_nail='" + product_thumb_nail + '\'' +
                ", product_title='" + product_title + '\'' +
                '}';
    }
}
