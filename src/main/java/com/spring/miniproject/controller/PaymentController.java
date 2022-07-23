package com.spring.miniproject.controller;

import com.spring.miniproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@Controller
@RequestMapping("/pay")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping("/kakaoPay")
    @ResponseBody
    public String kakaoPay(){

        return paymentService.paymentReady();
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
