package com.spring.miniproject.service;

import com.spring.miniproject.dao.SubCategoryDao;
import com.spring.miniproject.domain.SubCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    SubCategoryDao subCategoryDao;

    @Override
    public int insertSubCategory(SubCategoryDto subCategoryDto) throws Exception {
        return subCategoryDao.insertSubCategory(subCategoryDto);
    }

    @Override
    public List<SubCategoryDto> selectAllSubCategory() throws Exception {
        return subCategoryDao.selectAllSubCategory();
    }
    @Override
    public int countSubCategory() throws Exception {
        return subCategoryDao.countSubCategory();
    }

    @Override
    public int updateSubCategory(SubCategoryDto subCategoryDto) throws Exception {
        return subCategoryDao.updateSubCategory(subCategoryDto);
    }

    @Override
    public int deleteSubCategory(Integer sub_category_id) throws Exception {
        return subCategoryDao.deleteSubCategory(sub_category_id);
    }
}
