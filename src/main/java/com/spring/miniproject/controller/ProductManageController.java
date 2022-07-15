package com.spring.miniproject.controller;

import com.spring.miniproject.domain.CategoryDto;
import com.spring.miniproject.domain.ProductDto;
import com.spring.miniproject.domain.ProductOptionDto;
import com.spring.miniproject.domain.SubCategoryDto;
import com.spring.miniproject.service.CategoryService;
import com.spring.miniproject.service.ProductOptionService;
import com.spring.miniproject.service.ProductService;
import com.spring.miniproject.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productmanage")
public class ProductManageController {

    @Autowired
    ProductOptionService productOptionService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String productManagePage() {
        return "productManage.tiles";
    }
    //  상품 상위 옵션

    // 상품 상위 옵션 목록 불러오기
    @GetMapping("/productoption/list")
    @ResponseBody
    public ResponseEntity<List<ProductOptionDto>> getAllProductOptionList() {
        try {
            List<ProductOptionDto> productOptionList = productOptionService.selectAllProductOption();

            return new ResponseEntity<>(productOptionList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    // 상품 상위 옵션을 DB에 추가하기
    @PostMapping("/productoption/add")
    @ResponseBody
    public ResponseEntity<String> addProductOption(@RequestBody ProductOptionDto productOptionDto, Model m) {
        try {
            int rowCnt = productOptionService.insertProductOption(productOptionDto);

            if(rowCnt != 1) {
                throw new Exception("상품 상위옵션 추가에 실패했습니다.");
            }

            return new ResponseEntity<>("PRODUCTOPTION ADD SUCCESS", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTION ADD ERR", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/productoption/modify")
    @ResponseBody
    public ResponseEntity<String> modifyProductOption(@RequestBody ProductOptionDto productOptionDto, Model m) {
        try {
            int rowCnt = productOptionService.updateProductOption(productOptionDto);

            if(rowCnt != 1) {
                throw new Exception("상품 상위옵션 수정에 실패했습니다.");
            }

            return new ResponseEntity<>("PRODUCTOPTION MODIFY SUCCESS", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTION MODIFY ERR", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/productoption/delete")
    @ResponseBody
    public ResponseEntity<String> deleteProductOption(Integer option_id, Model m) {
        try {
            int rowCnt = productOptionService.deleteProductOption(option_id);

            if(rowCnt != 1) {
                throw new Exception("상품 상위옵션 삭제에 실패했습니다.");
            }

            return new ResponseEntity<>("PRODUCTOPTION DELETE SUCCESS", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTION DELETE ERR", HttpStatus.BAD_REQUEST);

        }
    }
    // 상품 등록하기
    @GetMapping("/registerproduct")
    public String registerProduct(Model m) {
        try {
            List<CategoryDto> categoryList = categoryService.selectAllCategory();
            List<SubCategoryDto> subCategoryList = subCategoryService.selectAllSubCategory();

            m.addAttribute("categoryList", categoryList);
            m.addAttribute("subCategoryList", subCategoryList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "registerProduct";
    }

    @PostMapping("/registerproduct")
    @ResponseBody
    public String registerProduct(@RequestBody ProductDto productDto, Model m) {
        try {
            productDto.setProduct_thumb_nail("썸네일 임시 삽입");
            int rowCnt = productService.insertProduct(productDto);
            System.out.println("productDto = " + productDto);
            if(rowCnt != 1) {
                throw new Exception("상품 등록에 실패했습니다.");
            }

            return "redirect:/productmanage";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("productDto", productDto);
            return "registerProduct";
        }

    }

//    // 네이버 스마트에디터 test용, 상품 등록 페이지 보여주기
//    @GetMapping("/test")
//    public String test() {
//
//        return "test";
//    }
//
//    @PostMapping("/test2")
//    @ResponseBody
//    public String test2(@RequestBody String content) {
//        System.out.println("content = " + content);
//        return "test";
//    }

}
