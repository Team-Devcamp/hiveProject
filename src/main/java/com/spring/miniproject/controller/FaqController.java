package com.spring.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FaqController  {

    @RequestMapping(value = "/faq")
    public String faqList (HttpServletRequest request) throws Exception {
        return "faq";
    }
}
