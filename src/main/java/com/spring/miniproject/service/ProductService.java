package com.spring.miniproject.service;

import com.spring.miniproject.domain.ProductReviewDto;
import com.spring.miniproject.domain.ProductDto;
import com.spring.miniproject.domain.ProductSearchCondition;

import java.util.List;

public interface ProductService {
    int insertProduct(ProductDto productDto) throws Exception;

    ProductDto selectProduct(Integer product_id) throws Exception;

    List<ProductDto> selectAllProduct(Integer offset, Integer product_num) throws Exception;

    Integer selectAllProductCnt() throws Exception;

    List<ProductDto> selectSearchProduct(ProductSearchCondition psc) throws Exception;

    Integer selectSearchProductCnt(ProductSearchCondition psc) throws Exception;

    List<ProductDto> selectProductBySubCategory(Integer offset, Integer product_num, Integer sub_category_id) throws Exception;

    Integer selectProductBySubCategoryCnt(Integer sub_category_id) throws Exception;

    int updateProduct(ProductDto productDto) throws Exception;

    int deleteProduct(Integer product_id) throws Exception;

    int deleteAllProduct() throws Exception;
}
