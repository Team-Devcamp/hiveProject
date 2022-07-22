package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeDaoImpl implements HomeDao {

    @Autowired
    SqlSession session;

    private String namespace = "com.spring.miniproject.dao.HomeMapper.";

    @Override
    public List<ProductDto> selectPopularProduct() throws Exception {
        return session.selectList(namespace + "selectPopularProduct");
    }

    @Override
    public List<ProductDto> selectLatestProduct() throws Exception {
        return session.selectList(namespace + "selectLatestProduct");
    }

    @Override
    public List<ProductDto> searchSelect(String keyword) throws Exception {
        return session.selectList(namespace + "searchSelect", keyword);
    }

    @Override
    public int searchResultCnt(String keyword) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", keyword);
    }

}
