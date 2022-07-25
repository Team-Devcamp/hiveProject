package com.spring.miniproject.controller;

import com.spring.miniproject.domain.PurchaseProductDetailDto;
import com.spring.miniproject.service.KaKaoPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/pay")
public class PaymentController {
    @Autowired
    KaKaoPayService paymentService;

    @RequestMapping("/kakaoPay")
    @ResponseBody
    public String kakaoPay(HttpSession session){
        List<PurchaseProductDetailDto> orderList = (List)session.getAttribute("list");

        return paymentService.kakaoPayReady(orderList);
    }

    @GetMapping("/success")
    public String successKakaoPay(){
        return "/pay/success";
    }

    @GetMapping("/fail")
    public String failKakaoPay(){
        return "/pay/fail";
    }

    @GetMapping("/cancel")
    public String cancelKakaoPay(){
        return "/pay/cancel";
    }


}
