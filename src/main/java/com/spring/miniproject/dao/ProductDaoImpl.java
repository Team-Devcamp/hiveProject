package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductReviewDto;
import com.spring.miniproject.domain.ProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    SqlSession session;

    private String namespace = "com.spring.miniproject.dao.ProductMapper.";

    @Override
    public int insertProduct(ProductDto productDto) throws Exception {
        return session.insert(namespace + "insertProduct", productDto);
    }

    @Override
    public ProductDto selectProduct(Integer product_id) throws Exception {
        return session.selectOne(namespace + "selectProduct", product_id);
    }

    @Override
    public List<ProductDto> selectAllProduct() throws Exception {
        return session.selectList(namespace + "selectAllProduct");
    }

    @Override
    public int updateProduct(ProductDto productDto) throws Exception {
        return session.update(namespace + "updateProduct", productDto);
    }

    @Override
    public int deleteProduct(Integer product_id) throws Exception {
        return session.delete(namespace + "deleteProduct", product_id);
    }

    @Override
    public int deleteAllProduct() throws Exception {
        return session.delete(namespace + "deleteAllProduct");
    }
}