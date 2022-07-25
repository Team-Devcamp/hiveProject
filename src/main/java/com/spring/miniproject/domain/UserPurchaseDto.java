package com.spring.miniproject.domain;


import java.util.Date;

public class UserPurchaseDto {
    private Integer purchase_product_details_id;
    private Integer purchase_id;
    private Integer product_id;
    private String  product_thumb_nail;
    private Integer qty;
    private Date purchase_date;
    private String product_title;
    private Integer user_id;
    private String option_color;
    private String option_size;

    public UserPurchaseDto(Integer purchase_product_details_id, Integer purchase_id, Integer product_id, String product_thumb_nail, Integer qty,
                           Date purchase_date,String product_title,Integer user_id,String option_color, String option_size) {
        this.purchase_product_details_id = purchase_product_details_id;
        this.purchase_id = purchase_id;
        this.product_id = product_id;
        this.product_thumb_nail = product_thumb_nail;
        this.qty = qty;
        this.purchase_date = purchase_date;
        this.product_title = product_title;
        this.user_id = user_id;
        this.option_color = option_color;
        this.option_size = option_size;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public Integer getPurchase_product_details_id() {
        return purchase_product_details_id;
    }

    public void setPurchase_product_details_id(Integer purchase_product_details_id) {
        this.purchase_product_details_id = purchase_product_details_id;
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

    public String getProduct_thumb_nail() {
        return product_thumb_nail;
    }

    public void setProduct_thumb_nail(String product_thumb_nail) {
        this.product_thumb_nail = product_thumb_nail;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getOption_color() {
        return option_color;
    }

    public void setOption_color(String option_color) {
        this.option_color = option_color;
    }

    public String getOption_size() {
        return option_size;
    }

    public void setOption_size(String option_size) {
        this.option_size = option_size;
    }
}
