package com.spring.miniproject.controller;

import com.spring.miniproject.domain.ProductReviewDto;
import com.spring.miniproject.domain.CategoryDto;
import com.spring.miniproject.domain.ProductDto;
import com.spring.miniproject.domain.SubCategoryDto;
import com.spring.miniproject.service.CategoryService;
import com.spring.miniproject.service.ProductService;
import com.spring.miniproject.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/detail")
    public String ProductDetailPage() { // product_id로 select문

        return "product/product_detail.tiles";
    }

    // 상품 리스트 보여주기
    @GetMapping("/list")
    public String getProductList(Model m) {

        try {
            List<ProductDto> productList = productService.selectAllProduct();
            List<CategoryDto> categoryList = categoryService.selectAllCategory();

            // 큰 카테고리와 서브 카테고리 목록을 map으로 저장하여 view에 전달함
            Map<String, List<SubCategoryDto>> categoryMap = new HashMap<>();

            // 상위 카테고리를 하나씩 꺼내서 반복문 실행
            for (int i=0; i < categoryList.size(); i++) {
                // 카테고리 이름
                String category_name = categoryList.get(i).getCategory_name();
                // 카테고리 번호
                Integer category_id = categoryList.get(i).getCategory_id();
                // 특정 서브카테고리 리스트 가져오기
                List<SubCategoryDto> subCategoryList = subCategoryService.selectSpecificSubCategory(category_id);
                // map에 key = 카테고리 이름, value = 하위 카테고리 목록을 저장함
                categoryMap.put(category_name, subCategoryList);
            }

            m.addAttribute("productList", productList);
//            m.addAttribute("categoryList", categoryList);
            m.addAttribute("categoryMap", categoryMap);

        } catch(Exception e) {
            e.printStackTrace();
        }
        return "product/productList.tiles";
    }

}