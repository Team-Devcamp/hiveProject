package com.spring.miniproject.domain;

import java.util.Objects;

public class CategoryDto {
    private Integer category_id;
    private String category_name;

    // 기본 생성자
    public CategoryDto() {}

    // 생성자
    public CategoryDto(Integer category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    // getter, setter
    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryDto)) return false;
        CategoryDto that = (CategoryDto) o;
        return Objects.equals(getCategory_id(), that.getCategory_id()) && Objects.equals(getCategory_name(), that.getCategory_name());
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getCategory_id(), getCategory_name());
    }

    // toString
    @Override
    public String toString() {
        return "CategoryDto{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }

}
