package com.spring.miniproject.service;

import com.spring.miniproject.domain.CategoryDto;

import java.util.List;

public interface CategoryService {
    int addCategory(CategoryDto categoryDto) throws Exception;

    CategoryDto readCategory(Integer category_id) throws Exception;

    List<CategoryDto> getAllCategoryList() throws Exception;

    int getNumberOfCategories() throws Exception;

    int modifyCategory(CategoryDto categoryDto) throws Exception;

    int removeCategory(Integer category_id) throws Exception;

    int removeAllCategory() throws Exception;
}
