package com.spring.miniproject.domain;

public class PurchaseProductDetailsDto {
    private int purchase_product_details_id;
    private int purchase_id;
    private int product_id;
    private String option_color;
    private String option_size;
    private int price;
    private int qty;
    private int sub_total_price;

    public PurchaseProductDetailsDto() {}

    public PurchaseProductDetailsDto(int purchase_product_details_id) {
        this.purchase_product_details_id = purchase_product_details_id;
    }

    public int getPurchase_product_details_id() {
        return purchase_product_details_id;
    }

    public void setPurchase_product_details_id(int purchase_product_details_id) {
        this.purchase_product_details_id = purchase_product_details_id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSub_total_price() {
        return sub_total_price;
    }

    public void setSub_total_price(int sub_total_price) {
        this.sub_total_price = sub_total_price;
    }

    @Override
    public String toString() {
        return "purchaseProductDetailDto{" +
                "purchase_product_details_id=" + purchase_product_details_id +
                ", purchase_id=" + purchase_id +
                ", product_id=" + product_id +
                ", option_color='" + option_color + '\'' +
                ", option_size='" + option_size + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", sub_total_price=" + sub_total_price +
                '}';
    }
}
