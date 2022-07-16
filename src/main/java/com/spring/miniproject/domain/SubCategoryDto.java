package com.spring.miniproject.domain;

import java.util.Objects;

public class SubCategoryDto {
    private Integer sub_category_id;
    private Integer category_id;
    private String sub_category_name;

    // 기본 생성자
    public SubCategoryDto() {}

    // 생성자
    public SubCategoryDto(Integer sub_category_id, Integer category_id, String sub_category_name) {
        this.sub_category_id = sub_category_id;
        this.category_id = category_id;
        this.sub_category_name = sub_category_name;
    }

    // getter, setter
    public Integer getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(Integer sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }

    public void setSub_category_name(String sub_category_name) {
        this.sub_category_name = sub_category_name;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubCategoryDto)) return false;
        SubCategoryDto that = (SubCategoryDto) o;
        return Objects.equals(getSub_category_id(), that.getSub_category_id()) && Objects.equals(getCategory_id(), that.getCategory_id()) && Objects.equals(getSub_category_name(), that.getSub_category_name());
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getSub_category_id(), getCategory_id(), getSub_category_name());
    }

    // toString
    @Override
    public String toString() {
        return "SubCategoryDto{" +
                "sub_category_id=" + sub_category_id +
                ", category_id=" + category_id +
                ", sub_category_name='" + sub_category_name + '\'' +
                '}';
    }
}
