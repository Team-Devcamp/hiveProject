package com.spring.miniproject.domain;

import java.util.Objects;

public class ProductOptionDto {
    private Integer option_id;
    private Integer product_id;
    private String option_name;

    // 기본생성자
    public ProductOptionDto() {}

    // 생성자
    public ProductOptionDto(Integer option_id, Integer product_id, String option_name) {
        this.option_id = option_id;
        this.product_id = product_id;
        this.option_name = option_name;
    }

    // getter, setter
    public Integer getOption_id() {
        return option_id;
    }

    public void setOption_id(Integer option_id) {
        this.option_id = option_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getOption_name() {
        return option_name;
    }

    public void setOption_name(String option_name) {
        this.option_name = option_name;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOptionDto)) return false;
        ProductOptionDto that = (ProductOptionDto) o;
        return Objects.equals(getOption_id(), that.getOption_id()) && Objects.equals(getProduct_id(), that.getProduct_id()) && Objects.equals(getOption_name(), that.getOption_name());
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getOption_id(), getProduct_id(), getOption_name());
    }

    // toString
    @Override
    public String toString() {
        return "ProductOptionDto{" +
                "option_id=" + option_id +
                ", product_id=" + product_id +
                ", option_name='" + option_name + '\'' +
                '}';
    }
}
