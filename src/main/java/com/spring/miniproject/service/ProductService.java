package com.spring.miniproject.service;

import com.spring.miniproject.domain.ProductReviewDto;
import com.spring.miniproject.domain.ProductDto;

import java.util.List;

public interface ProductService {
    int insertProduct(ProductDto productDto) throws Exception;

    ProductDto selectProduct(Integer product_id) throws Exception;

    List<ProductDto> selectAllProduct() throws Exception;

    int updateProduct(ProductDto productDto) throws Exception;

    int deleteProduct(Integer product_id) throws Exception;

    int deleteAllProduct() throws Exception;
}
