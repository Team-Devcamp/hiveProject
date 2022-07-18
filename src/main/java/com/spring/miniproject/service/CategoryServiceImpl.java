package com.spring.miniproject.service;

import com.spring.miniproject.dao.CategoryDao;
import com.spring.miniproject.dao.ProductOptionDao;
import com.spring.miniproject.domain.CategoryDto;
import com.spring.miniproject.domain.ProductOptionDto;
import com.spring.miniproject.domain.SubCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public int insertCategory(CategoryDto categoryDto) throws Exception {
        return categoryDao.insertCategory(categoryDto);
    }

    @Override
    public CategoryDto selectCategory(Integer category_id) throws Exception {
        return categoryDao.selectCategory(category_id);
    }

    @Override
    public List<CategoryDto> selectAllCategory() throws Exception {
        return categoryDao.selectAllCategory();
    }

    @Override
    public int countCategories() throws Exception {
        return categoryDao.countCategory();
    }

    @Override
    public int updateCategory(CategoryDto categoryDto) throws Exception {
        return categoryDao.updateCategory(categoryDto);
    }

    @Override
    public int deleteCategory(Integer category_id) throws Exception {
        return categoryDao.deleteCategory(category_id);
    }

    @Override
    public int deleteAllCategory() throws Exception {
        return categoryDao.deleteAllCategory();
    }

}
