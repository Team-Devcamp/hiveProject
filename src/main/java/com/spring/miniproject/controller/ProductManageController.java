package com.spring.miniproject.controller;

import com.spring.miniproject.domain.ProductOptionDto;
import com.spring.miniproject.service.ProductOptionService;
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

}
