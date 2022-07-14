package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductDto;

import java.util.List;

public interface ProductDao {
    int insertProduct(ProductDto productDto) throws Exception;

    ProductDto selectProduct(Integer product_id) throws Exception;

    List<ProductDto> selectAllProduct() throws Exception;

    int updateProduct(ProductDto productDto) throws Exception;

    int deleteProduct(Integer product_id) throws Exception;

    int deleteAllProduct() throws Exception;
}
