package com.spring.miniproject.domain;

import java.util.Objects;

public class ProductStockDto {
    private Integer product_id;
    private Integer option_id;
    private Integer option_detail_id;
    private Integer product_stock;

    // 기본 생성자
    public ProductStockDto() {}

    // 생성자
    public ProductStockDto(Integer product_id, Integer option_id, Integer option_detail_id, Integer product_stock) {
        this.product_id = product_id;
        this.option_id = option_id;
        this.option_detail_id = option_detail_id;
        this.product_stock = product_stock;
    }

    // getter, setter
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getOption_id() {
        return option_id;
    }

    public void setOption_id(Integer option_id) {
        this.option_id = option_id;
    }

    public Integer getOption_detail_id() {
        return option_detail_id;
    }

    public void setOption_detail_id(Integer option_detail_id) {
        this.option_detail_id = option_detail_id;
    }

    public Integer getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(Integer product_stock) {
        this.product_stock = product_stock;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductStockDto)) return false;
        ProductStockDto that = (ProductStockDto) o;
        return Objects.equals(getProduct_id(), that.getProduct_id()) && Objects.equals(getOption_id(), that.getOption_id()) && Objects.equals(getOption_detail_id(), that.getOption_detail_id()) && Objects.equals(getProduct_stock(), that.getProduct_stock());
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getProduct_id(), getOption_id(), getOption_detail_id(), getProduct_stock());
    }

    // toString
    @Override
    public String toString() {
        return "ProductStockDto{" +
                "product_id=" + product_id +
                ", option_id=" + option_id +
                ", option_detail_id=" + option_detail_id +
                ", product_stock=" + product_stock +
                '}';
    }
}
