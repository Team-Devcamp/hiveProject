package com.spring.miniproject.service;

import com.spring.miniproject.domain.ProductOptionDetailDto;
import com.spring.miniproject.domain.ProductOptionDto;

import java.util.List;

public interface ProductOptionDetailService{

    int insertProductDetailOption(ProductOptionDetailDto productOptionDetailDto) throws Exception;

    ProductOptionDetailDto selectProductDetailOption(Integer option_detail_id) throws Exception;

    List<ProductOptionDetailDto> selectAllProductDetailOption(Integer product_detail_id) throws Exception;

    int countProductDetailOption() throws Exception;

    int updateProductDetailOption(ProductOptionDetailDto productOptionDetailDto) throws Exception;

    int deleteProductDetailOption(Integer option_id) throws Exception;

    int deleteAllProductDetailOption() throws Exception;
}
