package com.spring.miniproject.controller;

import com.spring.miniproject.dao.ProductDao;
import com.spring.miniproject.domain.ProductDto;
import com.spring.miniproject.domain.PurchaseProductDetailsDto;
import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.service.ProductService;
import com.spring.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @PostMapping("/page")
    public String purchasePage(int product_id, int[] qty, String[] option_color, String[] option_size, String[] subTotalPrice,
                               int total_price, String product_title, Model m, HttpSession session){
        List list = new ArrayList();
        String user_email = (String)session.getAttribute("user_email");

        for(int i=0; i<qty.length; i++) {
            PurchaseProductDetailsDto dto = new PurchaseProductDetailsDto();

                System.out.println("선택물품");
                System.out.println("product_id = " + product_id);
                System.out.println("qty[i] = " + qty[i]);
                System.out.println("option_color = " + option_color[i]);
                System.out.println("option_size = " + option_size[i]);
                System.out.println("subTotalPrice = " + subTotalPrice[i]);
                System.out.println("total_price = " + total_price);
                System.out.println("title = " + product_title);
                System.out.println("user_email = " + user_email);

                dto.setProduct_id(product_id);
                dto.setQty(qty[i]);
                dto.setOption_color(option_color[i]);
                dto.setOption_size(option_size[i]);
                dto.setSub_total_price(Integer.parseInt(subTotalPrice[i]));
                list.add(dto);
        }

        try {
            ProductDto productDto = productService.selectProduct(product_id);
            m.addAttribute("productDto",productDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m.addAttribute("list",list);
        m.addAttribute("total_price",total_price);
        m.addAttribute("product_title",product_title);
        m.addAttribute("user_email",user_email);

        session.setAttribute("list",list);
        session.setAttribute("total_price",total_price);

        return "purchase/purchase.tiles";
    }

    @GetMapping("/purchaser")
    @ResponseBody
    public UserDto purchaser(HttpSession session, Model m){
        UserDto userDto;
        String user_email = (String)session.getAttribute("user_email");
        userDto = userService.selectOneUser(user_email);

        return userDto;
    }

}
