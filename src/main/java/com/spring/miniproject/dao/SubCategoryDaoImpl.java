package com.spring.miniproject.dao;

import com.spring.miniproject.domain.SubCategoryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubCategoryDaoImpl implements SubCategoryDao {

    @Autowired
    SqlSession session;

    private String namespace = "com.spring.miniproject.dao.SubCategoryMapper.";

    @Override
    public int insertSubCategory(SubCategoryDto subCategoryDto) throws Exception {
        return session.insert(namespace + "insertSubCategory", subCategoryDto);
    }

    @Override
    public List<SubCategoryDto> selectAllSubCategory() throws Exception {
        return session.selectList(namespace + "selectAllSubCategory");
    }

    @Override
    public int countSubCategory() throws Exception {
        return session.selectOne(namespace + "countSubCategory");
    }

    @Override
    public int updateSubCategory(SubCategoryDto subCategoryDto) throws Exception {
        return session.update(namespace + "updateSubCategory", subCategoryDto);
    }

    @Override
    public int deleteSubCategory(Integer sub_category_id) throws Exception {
        return session.delete(namespace + "deleteSubCategory", sub_category_id);
    }

}
