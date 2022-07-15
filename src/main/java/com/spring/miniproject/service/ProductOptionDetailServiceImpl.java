package com.spring.miniproject.service;

import com.spring.miniproject.dao.ProductOptionDetailDao;
import com.spring.miniproject.domain.ProductOptionDetailDto;
import com.spring.miniproject.domain.SubCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductOptionDetailServiceImpl implements ProductOptionDetailService{
    @Autowired
    ProductOptionDetailDao productOptionDetailDao;

    @Override
    public int insertProductDetailOption(ProductOptionDetailDto productOptionDetailDto) throws Exception {
        return productOptionDetailDao.insertProductDetailOption(productOptionDetailDto);
    }

    @Override
    public ProductOptionDetailDto selectProductDetailOption(Integer option_detail_id) throws Exception {
        return productOptionDetailDao.selectProductDetailOption(option_detail_id);
    }

    @Override
    public List<ProductOptionDetailDto> selectSpecificProductOptionDetail(Integer product_id, Integer option_id) throws Exception {
        Map<String, Integer> map = new HashMap();
        map.put("product_id", product_id);
        map.put("option_id", option_id);

        return productOptionDetailDao.selectSpecificProductOptionDetail(map);
    }

    @Override
    public List<ProductOptionDetailDto> selectAllProductDetailOption() throws Exception {
        return productOptionDetailDao.selectAllProductDetailOption();
    }

    @Override
    public int countProductDetailOption() throws Exception {
        return productOptionDetailDao.countProductDetailOption();
    }

    @Override
    public int updateProductDetailOption(ProductOptionDetailDto productOptionDetailDto) throws Exception {
        return productOptionDetailDao.updateProductDetailOption(productOptionDetailDto);
    }

    @Override
    public int deleteProductDetailOption(Integer option_id) throws Exception {
        return productOptionDetailDao.deleteProductDetailOption(option_id);
    }

    @Override
    public int deleteAllProductDetailOption() throws Exception {
        return productOptionDetailDao.deleteAllProductDetailOption();
    }
}
