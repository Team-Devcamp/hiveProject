package com.spring.miniproject.controller;

import com.spring.miniproject.domain.CategoryDto;
import com.spring.miniproject.domain.SubCategoryDto;
import com.spring.miniproject.service.CategoryService;
import com.spring.miniproject.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/categorymanage")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("")
    public String getAllCategory() {
        return "category/categoryList.tiles";
    }

    // 등록된 카테고리 목록 보여주기
    @GetMapping("/categorylist")
    @ResponseBody
    public ResponseEntity<List<CategoryDto>> getAllCategoryList() {
        List<CategoryDto> categoryList = null;
        try {
            categoryList = categoryService.selectAllCategory();
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    // 카테고리 DB에 추가
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addCategory(@RequestBody CategoryDto categoryDto) {
        try {
            int rowCnt = categoryService.insertCategory(categoryDto);
            
            if(rowCnt != 1) {
                throw new Exception("카테고리 추가에 실패했습니다.");
            }
            return new ResponseEntity<>("CATEGORY_ADD_SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("CATEGORY_ADD_ERR", HttpStatus.BAD_REQUEST);
        }
    }

    // 카테고리 수정하기
    @PostMapping("/modify")
    @ResponseBody
    public ResponseEntity<String> modifyCategory(@RequestBody CategoryDto categoryDto, Model m, HttpServletRequest request, RedirectAttributes rattr) {
        try {
//            HttpSession session = request.getSession();
            int rowCnt = categoryService.updateCategory(categoryDto);

            if(rowCnt != 1) {
                throw new Exception("카테고리 수정에 실패했습니다.");
            }

            return new ResponseEntity<>("CATEGORY_MODIFY_SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("categoryDto", categoryDto);
            return new ResponseEntity<>("CATEGORY_MODIFY_ERR", HttpStatus.BAD_REQUEST);
        }

    }

    // 카테고리 삭제
    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> deleteCategory(@RequestBody Integer category_id) {

        try {
            int rowCnt = categoryService.deleteCategory(category_id);

            if(rowCnt != 1) {
                throw new Exception("카테고리 삭제에 실패했습니다.");
            }
            return new ResponseEntity<>("CATEGORY_REMOVE_SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("CATEGORY_REMOVE_ERR", HttpStatus.BAD_REQUEST);
        }

    }


    /*
    서브 카테고리 등록, 수정, 삭제
    ex) 상의 - 셔츠, 반팔티, 맨투맨
        하의 - 청바지, 반바지
    */

    // 서브카테고리 목록 보여주기
    @GetMapping("/subcategorylist")
    @ResponseBody
    public List<SubCategoryDto> getAllSubCategoryList() {
        List<SubCategoryDto> subCategoryList = null;
        try {
            subCategoryList = subCategoryService.selectAllSubCategory();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subCategoryList;
    }

    // 서브카테고리 추가하기
    @PostMapping("/addsub")
    @ResponseBody
    public ResponseEntity<String> addSubCategory(@RequestBody SubCategoryDto subCategoryDto) {

        try {
            int rowCnt = subCategoryService.insertSubCategory(subCategoryDto);

            if(rowCnt != 1) {
                throw new Exception("서브 카테고리 추가에 실패했습니다.");
            }

            return new ResponseEntity<>("SUBCATEGORY_ADD_SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("SUBCATEGORY_ADD_ERR", HttpStatus.BAD_REQUEST);
        }
    }

    // 서브카테고리 수정하기
    @PostMapping("/modifysub")
    @ResponseBody
    public ResponseEntity<String> modifySubCategory(@RequestBody SubCategoryDto subCategoryDto, Model m) {
        try {
//            HttpSession session = request.getSession();
            int rowCnt = subCategoryService.updateSubCategory(subCategoryDto);

            if(rowCnt != 1) {
                throw new Exception("서브카테고리 수정에 실패했습니다.");
            }

            return new ResponseEntity<>("SUBCATEGORY_MODIFY_SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("subCategoryDto", subCategoryDto);
            return new ResponseEntity<>("SUBCATEGORY_MODIFY_ERR", HttpStatus.BAD_REQUEST);
        }

    }

    // 서브카테고리 삭제
    @PostMapping("/deletesub")
    @ResponseBody
    public ResponseEntity<String> deleteSubCategory(@RequestBody Integer sub_category_id) {

        try {
            int rowCnt = subCategoryService.deleteSubCategory(sub_category_id);

            if(rowCnt != 1) {
                throw new Exception("카테고리 삭제에 실패했습니다.");
            }
            return new ResponseEntity<>("SUBCATEGORY_REMOVE_SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("SUBCATEGORY_REMOVE_ERR", HttpStatus.BAD_REQUEST);
        }

    }

}
