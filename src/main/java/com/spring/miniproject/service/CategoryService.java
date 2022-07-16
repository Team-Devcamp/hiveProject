package com.spring.miniproject.service;

import com.spring.miniproject.domain.CategoryDto;
import com.spring.miniproject.domain.ProductOptionDto;

import java.util.List;

public interface CategoryService {

    int insertCategory(CategoryDto categoryDto) throws Exception;

    CategoryDto selectCategory(Integer category_id) throws Exception;

    List<CategoryDto> selectAllCategory() throws Exception;

    int countCategories() throws Exception;

    int updateCategory(CategoryDto categoryDto) throws Exception;

    int deleteCategory(Integer category_id) throws Exception;

    int deleteAllCategory() throws Exception;

}
