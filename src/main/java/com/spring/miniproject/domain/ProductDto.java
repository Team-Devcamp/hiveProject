package com.spring.miniproject.domain;

import java.util.Objects;

public class ProductDto {
    private Integer product_id;
    private String product_name;
    private String product_title;
    private String product_info;
    private Integer product_price;
    private Integer category_id;
    private Integer sub_category_id;

    // 기본 생성자
    public ProductDto() {}

    // 생성자
    public ProductDto(Integer product_id, String product_name, String product_title, String product_info, Integer product_price, Integer category_id, Integer sub_category_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_title = product_title;
        this.product_info = product_info;
        this.product_price = product_price;
        this.category_id = category_id;
        this.sub_category_id = sub_category_id;
    }

    // getter, setter
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_info() {
        return product_info;
    }

    public void setProduct_info(String product_info) {
        this.product_info = product_info;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(Integer sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    // equals, hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(getProduct_id(), that.getProduct_id()) && Objects.equals(getProduct_name(), that.getProduct_name()) && Objects.equals(getProduct_title(), that.getProduct_title()) && Objects.equals(getProduct_info(), that.getProduct_info()) && Objects.equals(getProduct_price(), that.getProduct_price()) && Objects.equals(getCategory_id(), that.getCategory_id()) && Objects.equals(getSub_category_id(), that.getSub_category_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct_id(), getProduct_name(), getProduct_title(), getProduct_info(), getProduct_price(), getCategory_id(), getSub_category_id());
    }

    // toString
    @Override
    public String toString() {
        return "ProductDto{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_title='" + product_title + '\'' +
                ", product_info='" + product_info + '\'' +
                ", product_price=" + product_price +
                ", category_id=" + category_id +
                ", sub_category_id=" + sub_category_id +
                '}';
    }

}

