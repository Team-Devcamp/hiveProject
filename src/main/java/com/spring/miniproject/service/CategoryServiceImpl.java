package com.spring.miniproject.service;

import com.spring.miniproject.dao.CategoryDao;
import com.spring.miniproject.domain.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public int addCategory(CategoryDto categoryDto) throws Exception {
        return categoryDao.insertCategory(categoryDto);
    }

    @Override
    public CategoryDto readCategory(Integer category_id) throws Exception {
        return categoryDao.selectCategory(category_id);
    }

    @Override
    public List<CategoryDto> getAllCategoryList() throws Exception {
        return categoryDao.selectAllCategory();
    }

    @Override
    public int getNumberOfCategories() throws Exception {
        return categoryDao.countCategory();
    }

    @Override
    public int modifyCategory(CategoryDto categoryDto) throws Exception {
        return categoryDao.updateCategory(categoryDto);
    }

    @Override
    public int removeCategory(Integer category_id) throws Exception {
        return categoryDao.deleteCategory(category_id);
    }

    @Override
    public int removeAllCategory() throws Exception {
        return categoryDao.deleteAllCategory();
    }
}
