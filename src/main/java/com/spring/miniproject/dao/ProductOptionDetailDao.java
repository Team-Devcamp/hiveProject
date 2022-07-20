package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductOptionDetailDto;
import com.spring.miniproject.domain.SubCategoryDto;

import java.util.List;
import java.util.Map;

public interface ProductOptionDetailDao {

    int insertProductOptionDetail(ProductOptionDetailDto productOptionDetailDto);

    ProductOptionDetailDto selectProductOptionDetail(Integer option_detail_id);

    List<ProductOptionDetailDto> selectAllProductOptionDetail();

    List<ProductOptionDetailDto> selectSpecificProductOptionDetail(Map<String, Integer> map);

    int countProductOptionDetail();

    int updateProductOptionDetail(ProductOptionDetailDto productOptionDetailDto);

    int deleteProductOptionDetail(Integer option_id);

    int deleteAllProductOptionDetail();

}
