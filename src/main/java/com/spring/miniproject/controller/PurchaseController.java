package com.spring.miniproject.controller;

import com.spring.miniproject.domain.PurchaseProductDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @PostMapping("/page")
    public String purchasePage(int[] qty, String[] option_color, String[] option_size, String[] subTotalPrice, int total_price, Model m){
        PurchaseProductDetailDto dto = new PurchaseProductDetailDto();
        List list = new ArrayList();

        for(int i=0; i<qty.length; i++) {
            System.out.println("선택물품");
            System.out.println("qty[i] = " + qty[i]);
            System.out.println("option_color[i] = " + option_color[i]);
            System.out.println("option_color[i] = " + option_size[i]);
            System.out.println("subTotalPrice = " + subTotalPrice[i]);
            System.out.println("total_price = " + total_price);

            dto.setQty(qty[i]);
            dto.setOption_color(option_color[i]);
            dto.setOption_size(option_size[i]);
            dto.setSub_total_price(Integer.parseInt(subTotalPrice[i]));
            list.add(dto);
        }

//        m.addAttribute("qty",qty);
//        m.addAttribute("option_color",option_color);
//        m.addAttribute("option_size",option_size);
//        m.addAttribute("sub_total_price",subTotalPrice);

        Map orderMap = new HashMap();
        orderMap.put("list",list);
        m.addAttribute("list",list);
        m.addAttribute("total_price",total_price);

        return "purchase/purchase.tiles";
    }



}
