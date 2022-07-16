package com.spring.miniproject.dao;

import com.spring.miniproject.domain.SubCategoryDto;

import java.util.List;

public interface SubCategoryDao {
    int insertSubCategory(SubCategoryDto subCategoryDto) throws Exception;

    List<SubCategoryDto> selectAllSubCategory() throws Exception;

    List<SubCategoryDto> selectSpecificSubCategory(Integer category_id) throws Exception;

    int countSubCategory() throws Exception;

    int updateSubCategory(SubCategoryDto subCategoryDto) throws Exception;

    int deleteSubCategory(Integer sub_category_id) throws Exception;
}
