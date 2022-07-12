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
        return session.insert(namespace + "insert", categoryDto);
    }

    @Override
    public CategoryDto selectCategory(Integer category_id) throws Exception {
        return session.selectOne(namespace + "select", category_id);
    }

    @Override
    public List<CategoryDto> selectAllCategory() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public int countCategory() throws Exception {
        return session.selectOne(namespace + "count");
    }

    @Override
    public int updateCategory(CategoryDto categoryDto) throws Exception {
        return session.update(namespace + "update", categoryDto);
    }

    @Override
    public int deleteCategory(Integer category_id) throws Exception {
        return session.delete(namespace + "delete", category_id);
    }

    @Override
    public int deleteAllCategory() throws Exception {
        return session.delete(namespace + "deleteAll");
    }
}
