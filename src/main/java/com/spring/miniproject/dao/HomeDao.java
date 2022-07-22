package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductDto;

import java.util.List;

public interface HomeDao {
    List<ProductDto> selectPopularProduct() throws Exception;

    List<ProductDto> selectLatestProduct() throws Exception;

    List<ProductDto> searchSelect(String keyword) throws Exception;

    int searchResultCnt(String keyword) throws Exception;
}
