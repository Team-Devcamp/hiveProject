package com.spring.miniproject.service;

import com.spring.miniproject.dao.ProductOptionDao;
import com.spring.miniproject.domain.ProductOptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOptionServiceImpl implements ProductOptionService {

    @Autowired
    ProductOptionDao productOptionDao;

    @Override
    public int insertProductOption(ProductOptionDto productOptionDto) throws Exception {
        return productOptionDao.insertProductOption(productOptionDto);
    }

    @Override
    public ProductOptionDto selectProductOption(Integer option_id) throws Exception {
        return productOptionDao.selectProductOption(option_id);
    }

    @Override
    public List<ProductOptionDto> selectAllProductOption(Integer product_id) throws Exception {
        return productOptionDao.selectAllProductOption(product_id);
    }

    @Override
    public int countProductOption() throws Exception {
        return productOptionDao.countProductOption();
    }

    @Override
    public int updateProductOption(ProductOptionDto productOptionDto) throws Exception {
        return productOptionDao.updateProductOption(productOptionDto);
    }

    @Override
    public int deleteProductOption(Integer option_id) throws Exception {
        return productOptionDao.deleteProductOption(option_id);
    }

    @Override
    public int deleteAllProductOption() throws Exception {
        return productOptionDao.deleteAllProductOption();
    }
}
