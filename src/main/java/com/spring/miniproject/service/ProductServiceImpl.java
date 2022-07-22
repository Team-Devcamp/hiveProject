package com.spring.miniproject.service;

import com.spring.miniproject.dao.ProductDao;
import com.spring.miniproject.domain.ProductDto;
import com.spring.miniproject.domain.ProductSearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<ProductDto> selectAllProduct(Integer offset, Integer product_num) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("offset", offset);
        map.put("product_num", product_num);
        return productDao.selectAllProduct(map);
    }

    @Override
    public Integer selectAllProductCnt() throws Exception {
        return productDao.selectAllProductCnt();
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
    public List<ProductDto> selectProductBySubCategory(Integer offset, Integer product_num, Integer sub_category_id) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("offset", offset);
        map.put("product_num", product_num);
        map.put("sub_category_id", sub_category_id);
        return productDao.selectProductBySubCategory(map);
    }

    @Override
    public Integer selectProductBySubCategoryCnt(Integer sub_category_id) throws Exception {
        return productDao.selectProductBySubCategoryCnt(sub_category_id);
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
