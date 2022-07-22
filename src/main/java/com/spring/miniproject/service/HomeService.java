package com.spring.miniproject.service;

import com.spring.miniproject.domain.ProductDto;

import java.util.List;

public interface HomeService {
    List<ProductDto> getPopularProduct() throws Exception;

    List<ProductDto> getLatestProduct() throws Exception;

    List<ProductDto> getSearch(String keyword) throws Exception;

    int getResultCnt (String keyword) throws Exception;
}
