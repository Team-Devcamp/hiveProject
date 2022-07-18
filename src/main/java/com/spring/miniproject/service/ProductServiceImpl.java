package com.spring.miniproject.service;

import com.spring.miniproject.dao.ProductDao;
import com.spring.miniproject.domain.ProductReviewDto;
import com.spring.miniproject.domain.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public int insertProduct(ProductDto productDto) throws Exception {
        return productDao.insertProduct(productDto);
    }

    @Override
    public ProductDto selectProduct(Integer product_id) throws Exception {
        return productDao.selectProduct(product_id);
    }

    @Override
    public List<ProductDto> selectAllProduct() throws Exception {
        return productDao.selectAllProduct();
    }

    @Override
    public int updateProduct(ProductDto productDto) throws Exception {
        return productDao.updateProduct(productDto);
    }

    @Override
    public int deleteProduct(Integer product_id) throws Exception {
        return productDao.deleteProduct(product_id);
    }
    
    @Override
    public int deleteAllProduct() throws Exception {
        return productDao.deleteAllProduct();
    }
}
