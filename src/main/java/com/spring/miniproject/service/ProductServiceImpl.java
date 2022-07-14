package com.spring.miniproject.service;

import com.spring.miniproject.dao.ProductDao;
import com.spring.miniproject.domain.ProductReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

}
