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
    public int insertProductOptionDetail(ProductOptionDetailDto productOptionDetailDto) {

        return session.insert(namespace+"insertProductOptionDetail",productOptionDetailDto);
    }

    @Override
    public ProductOptionDetailDto selectProductOptionDetail(Integer option_detail_id) {
        return session.selectOne(namespace+"selectProductOptionDetail",option_detail_id);
    }

    @Override
    public List<ProductOptionDetailDto> selectAllProductOptionDetail() {
        return session.selectList(namespace+"selectAllProductOptionDetail");
    }

    @Override
    public List<ProductOptionDetailDto> selectSpecificProductOptionDetail(Map<String, Integer> map) {
        return session.selectList(namespace+"selectSpecificProductOptionDetail", map);
    }

    @Override
    public int countProductOptionDetail() {
        return session.selectOne(namespace + "countProductOptionDetail");
    }

    @Override
    public int updateProductOptionDetail(ProductOptionDetailDto productOptionDetailDto) {
        return session.update(namespace + "updateProductOptionDetail", productOptionDetailDto);
    }

    @Override
    public int deleteProductOptionDetail(Integer option_detail_id) {
        return session.delete(namespace + "deleteProductOptionDetail", option_detail_id);
    }

    @Override
    public int deleteAllProductOptionDetail() {
        return session.delete(namespace + "deleteAllProductOptionDetail");
    }
}
