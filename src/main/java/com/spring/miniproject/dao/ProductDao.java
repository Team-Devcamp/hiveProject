package com.spring.miniproject.dao;

import com.spring.miniproject.domain.ProductReviewDto;
import com.spring.miniproject.domain.ProductDto;
import com.spring.miniproject.domain.ProductSearchCondition;

import java.util.List;

public interface ProductDao {
    int insertProduct(ProductDto productDto) throws Exception;

    ProductDto selectProduct(Integer product_id) throws Exception;

    List<ProductDto> selectAllProduct() throws Exception;

    List<ProductDto> selectSearchProduct(ProductSearchCondition psc) throws Exception;

    Integer selectSearchProductCnt(ProductSearchCondition psc) throws Exception;

    List<ProductDto> selectProductBySubCategory(Integer sub_category_id) throws Exception;

    int updateProduct(ProductDto productDto) throws Exception;

    int deleteProduct(Integer product_id) throws Exception;

    int deleteAllProduct() throws Exception;
}
