package com.spring.miniproject.service;

import com.spring.miniproject.dao.ProductDao;
import com.spring.miniproject.domain.ProductDto;
import com.spring.miniproject.domain.ProductSearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

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
    public List<ProductDto> selectSearchProduct(ProductSearchCondition psc) throws Exception {
        return productDao.selectSearchProduct(psc);
    }

    @Override
    public Integer selectSearchProductCnt(ProductSearchCondition psc) throws Exception {
        return productDao.selectSearchProductCnt(psc);
    }

    @Override
    public List<ProductDto> selectProductBySubCategory(Integer sub_category_id) throws Exception {
        return productDao.selectProductBySubCategory(sub_category_id);
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
