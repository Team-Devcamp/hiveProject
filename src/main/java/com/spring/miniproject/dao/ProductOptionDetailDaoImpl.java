package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductOptionDetailDto;
import com.spring.miniproject.domain.SubCategoryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductOptionDetailDaoImpl implements ProductOptionDetailDao{
    @Autowired
    SqlSession session;
    private String namespace = "com.spring.miniproject.dao.ProductOptionDetailMapper.";

    @Override
    public int insertProductDetailOption(ProductOptionDetailDto productOptionDetailDto) {

        return session.insert(namespace+"insertProductDetailOption",productOptionDetailDto);
    }

    @Override
    public ProductOptionDetailDto selectProductDetailOption(Integer option_detail_id) {
        return session.selectOne(namespace+"selectProductDetailOption",option_detail_id);
    }

    @Override
    public List<ProductOptionDetailDto> selectAllProductDetailOption() {
        return session.selectList(namespace+"selectAllProductDetailOption");
    }

    @Override
    public List<ProductOptionDetailDto> selectSpecificProductOptionDetail(Map<String, Integer> map) {
        return session.selectList(namespace+"selectSpecificProductOptionDetail", map);
    }

    @Override
    public int countProductDetailOption() {
        return session.selectOne(namespace + "countProductDetailOption");
    }

    @Override
    public int updateProductDetailOption(ProductOptionDetailDto productOptionDetailDto) {
        return session.update(namespace + "updateProductDetailOption", productOptionDetailDto);
    }

    @Override
    public int deleteProductDetailOption(Integer option_detail_id) {
        return session.delete(namespace + "deleteProductDetailOption", option_detail_id);
    }

    @Override
    public int deleteAllProductDetailOption() {
        return session.delete(namespace + "deleteAllProductDetailOption");
    }
}
