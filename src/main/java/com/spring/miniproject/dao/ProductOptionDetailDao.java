package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductOptionDetailDto;

import java.util.List;

public interface ProductOptionDetailDao {

    int insertProductDetailOption(ProductOptionDetailDto productOptionDetailDto);

    ProductOptionDetailDto selectProductDetailOption(Integer option_detail_id);

    List<ProductOptionDetailDto> selectAllProductDetailOption(Integer product_detail_id);

    int countProductDetailOption();

    int updateProductDetailOption(ProductOptionDetailDto productOptionDetailDto);

    int deleteProductDetailOption(Integer option_id);

    int deleteAllProductDetailOption();
}
