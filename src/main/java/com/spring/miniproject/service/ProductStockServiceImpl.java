package com.spring.miniproject.service;

import com.spring.miniproject.dao.ProductStockDao;
import com.spring.miniproject.domain.ProductStockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStockServiceImpl implements ProductStockService {

    @Autowired
    private ProductStockDao productStockDao;

    @Override
    public int insertProductStock(ProductStockDto productStockDto) throws Exception {
        return productStockDao.insertProductStock(productStockDto);
    }

    @Override
    public ProductStockDto selectProductStock(ProductStockDto productStockDto) throws Exception {
        return productStockDao.selectProductStock(productStockDto);
    }

    @Override
    public int updateProductStock(ProductStockDto productStockDto) throws Exception {
        return productStockDao.updateProductStock(productStockDto);
    }

    @Override
    public int deleteProductStock(ProductStockDto productStockDto) throws Exception {
        return productStockDao.deleteProductStock(productStockDto);
    }
}
