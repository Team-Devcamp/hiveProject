package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductReviewDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SqlSession sqlSession;
    private String namespace = "com.spring.miniproject.dao.ProductReviewMapper.";


}
