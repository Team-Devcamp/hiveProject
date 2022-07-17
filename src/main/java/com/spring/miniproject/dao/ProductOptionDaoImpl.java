package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductOptionDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductOptionDaoImpl implements ProductOptionDao {

    @Autowired
    SqlSession session;

    private String namespace = "com.spring.miniproject.dao.CategoryMapper.";

    @Override
    public int insertProductOption(ProductOptionDto productOptionDto) throws Exception {
        return session.insert(namespace + "insertProductOption", productOptionDto);
    }

    @Override
    public ProductOptionDto selectProductOption(Integer option_id) throws Exception {
        return session.selectOne(namespace + "selectProductOption", option_id);
    }

    @Override
    public List<ProductOptionDto> selectAllProductOption(Integer product_id) throws Exception {
        return session.selectList(namespace + "selectAllProductOption", product_id);
    }

    @Override
    public int countProductOption() throws Exception {
        return session.selectOne(namespace + "countProductOption");
    }

    @Override
    public int updateProductOption(ProductOptionDto productOptionDto) throws Exception {
        return session.update(namespace + "updateProductOption", productOptionDto);
    }

    @Override
    public int deleteProductOption(Integer option_id) throws Exception {
        return session.delete(namespace + "deleteProductOption", option_id);
    }

    @Override
    public int deleteAllProductOption() throws Exception {
        return session.delete(namespace + "deleteAllProductOption");
    }
}
