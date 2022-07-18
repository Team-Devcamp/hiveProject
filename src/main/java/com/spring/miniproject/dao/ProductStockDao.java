package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductStockDto;

public interface ProductStockDao {
    int insertProductStock(ProductStockDto productStockDto) throws Exception;

    ProductStockDto selectProductStock(ProductStockDto productStockDto) throws Exception;

    int updateProductStock(ProductStockDto productStockDto) throws Exception;

    int deleteProductStock(ProductStockDto productStockDto) throws Exception;
}
