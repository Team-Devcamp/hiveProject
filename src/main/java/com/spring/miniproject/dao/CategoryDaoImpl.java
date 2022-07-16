package com.spring.miniproject.dao;

import com.spring.miniproject.domain.CategoryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    SqlSession session;

    private String namespace = "com.spring.miniproject.dao.CategoryMapper.";

    @Override
    public int insertCategory(CategoryDto categoryDto) throws Exception {
        return session.insert(namespace + "insertCategory", categoryDto);
    }

    @Override
    public CategoryDto selectCategory(Integer category_id) throws Exception {
        return session.selectOne(namespace + "selectCategory", category_id);
    }

    @Override
    public List<CategoryDto> selectAllCategory() throws Exception {
        return session.selectList(namespace + "selectAllCategory");
    }

    @Override
    public int countCategory() throws Exception {
        return session.selectOne(namespace + "countCategory");
    }

    @Override
    public int updateCategory(CategoryDto categoryDto) throws Exception {
        return session.update(namespace + "updateCategory", categoryDto);
    }

    @Override
    public int deleteCategory(Integer category_id) throws Exception {
        return session.delete(namespace + "deleteCategory", category_id);
    }

    @Override
    public int deleteAllCategory() throws Exception {
        return session.delete(namespace + "deleteAllCategory");
    }
}
