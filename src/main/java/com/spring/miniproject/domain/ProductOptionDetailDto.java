package com.spring.miniproject.domain;

public class ProductOptionDetailDto {
    private Integer option_detail_id;
    private Integer product_id;
    private Integer option_id;
    private String option_detail_name;

    public ProductOptionDetailDto() { }

    public ProductOptionDetailDto(Integer option_detail_id, Integer product_id, Integer option_id, String option_detail_name) {
        this.option_detail_id = option_detail_id;
        this.product_id = product_id;
        this.option_id = option_id;
        this.option_detail_name = option_detail_name;
    }

    public Integer getOption_detail_id() {
        return option_detail_id;
    }

    public void setOption_detail_id(Integer option_detail_id) {
        this.option_detail_id = option_detail_id;
    }

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

    public String getOption_detail_name() {
        return option_detail_name;
    }

    public void setOption_detail_name(String option_detail_name) {
        this.option_detail_name = option_detail_name;
    }

    @Override
    public String toString() {
        return "ProductOptionDetailDto{" +
                "option_detail_id=" + option_detail_id +
                ", product_id=" + product_id +
                ", option_id=" + option_id +
                ", option_detail_name='" + option_detail_name + '\'' +
                '}';
    }
}
