package com.spring.miniproject.service;

import com.spring.miniproject.domain.ProductOptionDto;

import java.util.List;

public interface ProductOptionService {

    int insertProductOption(ProductOptionDto productOptionDto) throws Exception;

    ProductOptionDto selectProductOption(Integer option_id) throws Exception;

    List<ProductOptionDto> selectAllProductOption(Integer product_id) throws Exception;

    int countProductOption() throws Exception;

    int updateProductOption(ProductOptionDto productOptionDto) throws Exception;

    int deleteProductOption(Integer option_id) throws Exception;

    int deleteAllProductOption() throws Exception;
}
