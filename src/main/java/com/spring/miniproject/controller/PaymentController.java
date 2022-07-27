package com.spring.miniproject.controller;

import com.spring.miniproject.domain.PurchaseDto;
import com.spring.miniproject.domain.PurchaseProductDetailsDto;
import com.spring.miniproject.service.KakaoPayService;
import com.spring.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/pay")
public class PaymentController {
    @Autowired
    KakaoPayService paymentService;
    @Autowired
    UserService userService;

    @RequestMapping("/kakaoPay")
    @ResponseBody
    public String kakaoPay(HttpSession session){
        return paymentService.kakaoPayReady(session);
    }

    @GetMapping("/kakaoPaySuccess")
    public String successKakaoPay(HttpSession session, @RequestParam("pg_token") String pg_token, Model m){
        System.out.println("kakaoPaySuccess get............................................");
        System.out.println("kakaoPaySuccess pg_token : " + pg_token);

        m.addAttribute("info", paymentService.kakaoPayInfo(pg_token,session));

        if(session.getAttribute("user_email")!=null) {
            m.addAttribute(session.getAttribute("user_email"));
            int user_id = userService.selectUserId((String)session.getAttribute("user_email"));
            List<PurchaseProductDetailsDto> orderList = (List)session.getAttribute("list");
            int product_id = orderList.get(0).getProduct_id();
            System.out.println("user_id = " + user_id + " product_id="+product_id);

            Map orderInfoMap = new HashMap();
            orderInfoMap.put("user_id",user_id);
            orderInfoMap.put("product_id",product_id);
            orderInfoMap.put("total_price",(int)session.getAttribute("total_price"));

            paymentService.insertPurchaseInfo(orderInfoMap);
            PurchaseDto purchaseDto = paymentService.selectPurchaseId(user_id);
            int purchase_id = purchaseDto.getPurchase_id();
            orderInfoMap.put("purchase_id",purchase_id);
            orderInfoMap.put("orderList", orderList);
            paymentService.insertPurchaseProduct(orderInfoMap);
        }
        return "/pay/success";
    }

    @GetMapping("/kakaoPayFail")
    public String failKakaoPay(){
        return "/pay/fail";
    }

    @GetMapping("/kakaoPayCancel")
    public String cancelKakaoPay(HttpSession session){
        session.removeAttribute("list");
        session.removeAttribute("total_price");
        return "/pay/cancel";
    }
}
