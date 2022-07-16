package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductOptionDetailDto;
import com.spring.miniproject.domain.SubCategoryDto;

import java.util.List;
import java.util.Map;

public interface ProductOptionDetailDao {

    int insertProductDetailOption(ProductOptionDetailDto productOptionDetailDto);

    ProductOptionDetailDto selectProductDetailOption(Integer option_detail_id);

    List<ProductOptionDetailDto> selectAllProductDetailOption();

    List<ProductOptionDetailDto> selectSpecificProductOptionDetail(Map<String, Integer> map);

    int countProductDetailOption();

    int updateProductDetailOption(ProductOptionDetailDto productOptionDetailDto);

    int deleteProductDetailOption(Integer option_id);

    int deleteAllProductDetailOption();

}
