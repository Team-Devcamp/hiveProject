package com.spring.miniproject.dao;

import com.spring.miniproject.domain.CategoryDto;

import java.util.List;

public interface CategoryDao {
    int insertCategory(CategoryDto categoryDto) throws Exception;

    CategoryDto selectCategory(Integer category_id) throws Exception;

    List<CategoryDto> selectAllCategory() throws Exception;

    int countCategory() throws Exception;

    int updateCategory(CategoryDto categoryDto) throws Exception;

    int deleteCategory(Integer category_id) throws Exception;

    int deleteAllCategory() throws Exception;
}
