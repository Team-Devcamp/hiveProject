package com.spring.miniproject.service;

import com.spring.miniproject.dao.HomeDao;
import com.spring.miniproject.domain.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeDao homeDao;

    @Override
    public List<ProductDto> getPopularProduct() throws Exception {
        return homeDao.selectPopularProduct();
    }

    @Override
    public List<ProductDto> getLatestProduct() throws Exception {
        return homeDao.selectLatestProduct();
    }

    @Override
    public List<ProductDto> getSearch(String keyword) throws Exception {
        return homeDao.searchSelect(keyword);
    }


    @Override
    public int getResultCnt (String keyword) throws Exception {
        return homeDao.searchResultCnt(keyword);
    }

}
