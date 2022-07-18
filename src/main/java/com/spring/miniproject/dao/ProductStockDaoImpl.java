package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductStockDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductStockDaoImpl implements ProductStockDao {

    private String namespace = "com.spring.miniproject.dao.ProductStockMapper.";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int insertProductStock(ProductStockDto productStockDto) throws Exception {
        return sqlSession.insert(namespace + "insertProductStock", productStockDto);
    }

    @Override
    public ProductStockDto selectProductStock(ProductStockDto productStockDto) throws Exception {
        return sqlSession.selectOne(namespace + "selectProductStock", productStockDto);
    }

    @Override
    public int updateProductStock(ProductStockDto productStockDto) throws Exception {
        return sqlSession.update(namespace + "updateProductStock", productStockDto);
    }

    @Override
    public int deleteProductStock(ProductStockDto productStockDto) throws Exception {
        return sqlSession.delete(namespace + "deleteProductStock", productStockDto);
    }
}
