package com.spring.miniproject.controller;

import com.spring.miniproject.domain.*;
import com.spring.miniproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
    @Autowired
    private ProductOptionService productOptionService;
    @Autowired
    private ProductOptionDetailService productOptionDetailService;

    // 전체 상품 리스트 보여주기
    @GetMapping("/list")
    public String getProductList(Integer sub_category_id, Model m) {
        List<ProductDto> productList = null;
        Integer productCnt = null;
        try {
            // 전체보기 눌렀을 때
            if(sub_category_id == null) {
                // offset과 product_num(한 번에 보여줄 상품의 갯수)를 설정하여 상품목록을 가져온다.
                productList = productService.selectAllProduct(0, 20);
                // 등록된 총 상품의 갯수
                productCnt = productService.selectAllProductCnt();

            // 특정 서브카테고리를 클릭했을 때
            } else {
                // offset과 product_num(한 번에 보여줄 상품의 갯수)를 설정하여 상품목록을 가져온다.
                productList = productService.selectProductBySubCategory(0, 20, sub_category_id);
                // 서브 카테고리 번호를 model에 저장
                m.addAttribute("sub_category_id", sub_category_id);
                // 상품 총 갯수
                productCnt = productService.selectProductBySubCategoryCnt(sub_category_id);
            }
            // 처음에 설정한 offset과 한 번에 보여줄 product의 갯수를 model에 저장한다.
            m.addAttribute("offset", 0);
            m.addAttribute("product_num", 20);
            // 등록된 총 상품의 갯수를 model에 저장한다.
            m.addAttribute("productCnt", productCnt);

            List<CategoryDto> categoryList = categoryService.selectAllCategory();
            // 카테고리와 서브 카테고리 목록을 map으로 저장하여 view에 전달함.
            // view에서 카테고리를 하나씩 꺼낼 때 저장 순서를 유지하기 위해 LinkedHashMap을 사용함.
            Map<String, List<SubCategoryDto>> categoryMap = new LinkedHashMap<>();

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
            m.addAttribute("categoryMap", categoryMap);

        } catch(Exception e) {
            e.printStackTrace();
        }
        return "product/productList.tiles";
    }
    // 상품 더 보기 버튼 눌렀을 때 Ajax로 상품 List를 정해진 개수씩 더 보여주기
    @GetMapping("/morelist")
    public ResponseEntity<List<ProductDto>> getMoreList(Integer offset, Integer product_num, Integer sub_category_id) {
        List<ProductDto> productList = null;
        try {
            if(sub_category_id == null) {
                productList = productService.selectAllProduct(offset, product_num);
            } else {
                productList = productService.selectProductBySubCategory(offset, product_num, sub_category_id);
            }

            return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 상품 상세페이지로 이동
    @GetMapping("/detail")
    public String ProductDetailPage(@RequestParam Integer product_id, Model m) {

        try {
            ProductDto productDto = productService.selectProduct(product_id);
            List<ProductOptionDto> productOptionList = productOptionService.
                                                            selectAllProductOption(product_id);

            Map<String, List<ProductOptionDetailDto>> optionMap = new HashMap<>();

            for(int i=0; i<productOptionList.size(); i++){
                String option_name = productOptionList.get(i).getOption_name();
                Integer option_id = productOptionList.get(i).getOption_id();
                System.out.println("넘어오나?"+option_name+" "+option_id);

                List<ProductOptionDetailDto> productOptionDetailList =
                        productOptionDetailService.selectSpecificProductOptionDetail(product_id,option_id);
                optionMap.put(option_name, productOptionDetailList);

                System.out.println(productOptionDetailList);
            }

            m.addAttribute("productDto", productDto);
            m.addAttribute("product_id",product_id);
            m.addAttribute("optionMap",optionMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "product/product_detail.tiles";
    }



}