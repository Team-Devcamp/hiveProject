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
    public int insertProductOptionDetail(ProductOptionDetailDto productOptionDetailDto) throws Exception {
        return productOptionDetailDao.insertProductOptionDetail(productOptionDetailDto);
    }

    @Override
    public ProductOptionDetailDto selectProductOptionDetail(Integer option_detail_id) throws Exception {
        return productOptionDetailDao.selectProductOptionDetail(option_detail_id);
    }

    @Override
    public List<ProductOptionDetailDto> selectSpecificProductOptionDetail(Integer product_id, Integer option_id) throws Exception {
        Map<String, Integer> map = new HashMap();
        map.put("product_id", product_id);
        map.put("option_id", option_id);

        return productOptionDetailDao.selectSpecificProductOptionDetail(map);
    }

    @Override
    public List<ProductOptionDetailDto> selectAllProductOptionDetail() throws Exception {
        return productOptionDetailDao.selectAllProductOptionDetail();
    }

    @Override
    public int countProductOptionDetail() throws Exception {
        return productOptionDetailDao.countProductOptionDetail();
    }

    @Override
    public int updateProductOptionDetail(ProductOptionDetailDto productOptionDetailDto) throws Exception {
        return productOptionDetailDao.updateProductOptionDetail(productOptionDetailDto);
    }

    @Override
    public int deleteProductOptionDetail(Integer option_id) throws Exception {
        return productOptionDetailDao.deleteProductOptionDetail(option_id);
    }

    @Override
    public int deleteAllProductOptionDetail() throws Exception {
        return productOptionDetailDao.deleteAllProductOptionDetail();
    }
}
