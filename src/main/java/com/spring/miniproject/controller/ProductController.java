package com.spring.miniproject.controller;

import com.spring.miniproject.domain.ProductReviewDto;
import com.spring.miniproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productDetailService;

    @GetMapping("/detail")
    public String ProductDetailPage(){
        return "product/product_detail.tiles";
    }





}