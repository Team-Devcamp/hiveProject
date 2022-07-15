package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductOptionDetailDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductOptionDetailDaoImpl implements ProductOptionDetailDao{
    @Autowired
    SqlSession session;
    private String namespace = "com.spring.miniproject.dao.CategoryMapper"

    @Override
    public int insertProductDetailOption(ProductOptionDetailDto productOptionDetailDto) {

        return 0;
    }

    @Override
    public ProductOptionDetailDto selectProductDetailOption(Integer option_detail_id) {
        return null;
    }

    @Override
    public List<ProductOptionDetailDto> selectAllProductDetailOption(Integer product_detail_id) {
        return null;
    }

    @Override
    public int countProductDetailOption() {
        return 0;
    }

    @Override
    public int updateProductDetailOption(ProductOptionDetailDto productOptionDetailDto) {
        return 0;
    }

    @Override
    public int deleteProductDetailOption(Integer option_id) {
        return 0;
    }

    @Override
    public int deleteAllProductDetailOption() {
        return 0;
    }
}
