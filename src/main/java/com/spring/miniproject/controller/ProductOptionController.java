package com.spring.miniproject.controller;

import com.spring.miniproject.domain.ProductOptionDto;
import com.spring.miniproject.service.ProductOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/productoption")
public class ProductOptionController {

    @Autowired
    ProductOptionService productOptionService;

    @GetMapping("/list")
    public String getAllProductOptionList(Model m) {
        try {
            List<ProductOptionDto> productOptionList = productOptionService.selectAllProductOption();

            m.addAttribute("productOptionList", productOptionList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "productOptionList";
    }


}
