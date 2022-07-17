package com.spring.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @GetMapping("/page")
    public String purchasePage(){
        return "purchase/purchase.tiles";
    }
}
