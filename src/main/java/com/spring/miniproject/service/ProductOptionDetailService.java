package com.spring.miniproject.service;

import com.spring.miniproject.domain.ProductOptionDetailDto;
import com.spring.miniproject.domain.ProductOptionDto;
import com.spring.miniproject.domain.SubCategoryDto;

import java.util.List;

public interface ProductOptionDetailService{

    int insertProductOptionDetail(ProductOptionDetailDto productOptionDetailDto) throws Exception;

    ProductOptionDetailDto selectProductOptionDetail(Integer option_detail_id) throws Exception;

    List<ProductOptionDetailDto> selectAllProductOptionDetail() throws Exception;

    List<ProductOptionDetailDto> selectSpecificProductOptionDetail(Integer product_id, Integer option_id) throws Exception;

    int countProductDetailOption() throws Exception;

    int updateProductOptionDetail(ProductOptionDetailDto productOptionDetailDto) throws Exception;

    int deleteProductOptionDetail(Integer option_id) throws Exception;

    int deleteAllProductOptionDetail() throws Exception;
}
