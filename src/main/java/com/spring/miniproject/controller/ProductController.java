package com.spring.miniproject.controller;

import com.spring.miniproject.domain.ProductReviewDto;
import com.spring.miniproject.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/detail")
    public String ProductDetailPage(){
        return "product/product_detail.tiles";
    }


    /*
    @GetMapping("/review")
    @ResponseBody
    public List<ProductReviewDto> ProductReview(String product_id){
        System.out.println("컨트롤러!!!!!!!!!!!!!!!!!1");
        System.out.println("product id = "+product_id);
        List<ProductReviewDto> list = productDetailService.selectReview(Integer.parseInt(product_id));

        for(ProductReviewDto p : list)
            System.out.println(p.toString());
        return list;
    }*/


    @GetMapping("/review")
    @ResponseBody
    public List<ProductReviewDto> ProductReview(@RequestParam String product_id){
        System.out.println("컨트롤러!!!!!!!!!!!!!!!!!1");
        System.out.println("product id = "+product_id);
        List<ProductReviewDto> list = productDetailService.selectReview(Integer.parseInt(product_id));
        System.out.println(list.get(0).toString());
        for(ProductReviewDto p : list)
            System.out.println(p.toString());

        return list;
    }

}
