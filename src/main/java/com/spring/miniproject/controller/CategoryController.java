package com.spring.miniproject.controller;

import com.spring.miniproject.domain.CategoryDto;
import com.spring.miniproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    // 등록된 카테고리 목록 보여주기
    @GetMapping("/list")
    public String getAllCategoryList(Model m) {
        try {
            List<CategoryDto> categoryList = categoryService.getAllCategoryList();
            m.addAttribute("categoryList", categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "categoryList";
    }

    // 카테고리 추가하는 form 보여주기
    @GetMapping("/add")
    public String addCategory(Model m) {
        m.addAttribute("mode", "new");
        return "addCategory";
    }

    // 작성한 form을 DB에 추가하기
    @PostMapping("/add")
    public String addCategory(CategoryDto categoryDto, Model m, RedirectAttributes rattr) {
        try {
            int rowCnt = categoryService.addCategory(categoryDto);

            if(rowCnt != 1) {
                throw new Exception("카테고리 추가에 실패했습니다.");
            }

            rattr.addFlashAttribute("msg", "CATEGORY_ADD_SUCCESS");
            return "redirect:/category/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("categoryDto", categoryDto);
            m.addAttribute("msg", "CATEGORY_ADD_ERR");
            return "addCategory";
        }
    }
    // 카테고리 읽기
    @GetMapping("/read")
    public String readCategory(Integer category_id) {
        try {
            CategoryDto categoryDto = categoryService.readCategory(category_id);

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/category/list";
        }

        return "Category";
    }

    // 카테고리 수정 화면 보여주기
    @GetMapping("/modify")
    public String modifyCategory(CategoryDto categoryDto, Model m) {

        return "addCategory";
    }

    // 카테고리 수정 내용을 DB에 반영
    @PostMapping("/modify")
    public String modifyCategory(CategoryDto categoryDto, Model m, HttpServletRequest request) {
        try {
//            HttpSession session = request.getSession();
            int rowCnt = categoryService.modifyCategory(categoryDto);
            System.out.println("rowCnt = " + rowCnt);
            System.out.println("categoryDto = " + categoryDto);
            if(rowCnt != 1) {
                throw new Exception("카테고리 수정에 실패했습니다.");
            }

            return "redirect:/category/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("categoryDto", categoryDto);
            return "addCategory";
        }

    }

    // 카테고리 삭제
    @PostMapping("/remove")
    public String removeCategory(Integer category_id, Model m) {
        try {
            int rowCnt = categoryService.removeCategory(category_id);

            if(rowCnt != 1) {
                throw new Exception("카테고리 삭제에 실패했습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/category/list";
    }

    // 카테고리 전체 삭제
    @PostMapping("removeAll")
    public String removeAllCategory() {
        try {
            int rowCnt = categoryService.removeAllCategory();
            if(rowCnt != 1) {
                throw new Exception("카테고리 전체 삭제에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/category/list";
    }
}
