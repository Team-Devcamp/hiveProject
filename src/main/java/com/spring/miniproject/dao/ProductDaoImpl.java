package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductDto;
import com.spring.miniproject.domain.ProductSearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    public Integer selectAllProductCnt() throws Exception {
        return session.selectOne(namespace + "selectAllProductCnt");
    }

    @Override
    public List<ProductDto> selectAllProduct(Map<String, Integer> map) throws Exception {
        return session.selectList(namespace + "selectAllProduct", map);
    }

    @Override
    public List<ProductDto> selectSearchProduct(ProductSearchCondition psc) throws Exception {
        return session.selectList(namespace + "selectSearchProduct", psc);
    }

    @Override
    public Integer selectSearchProductCnt(ProductSearchCondition psc) throws Exception {
        return session.selectOne(namespace + "selectSearchProductCnt", psc);
    }
    @Override
    public List<ProductDto> selectProductBySubCategory(Map<String, Integer> map) throws Exception {
        return session.selectList(namespace + "selectProductBySubCategory", map);
    }

    @Override
    public Integer selectProductBySubCategoryCnt(Integer sub_category_id) throws Exception {
        return session.selectOne(namespace + "selectProductBySubCategoryCnt", sub_category_id);
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
