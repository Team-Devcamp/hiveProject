package com.spring.miniproject.controller;

import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MyPageController {

    @Autowired
    UserService userService;

    @RequestMapping("/mypage")
    public String myPage(HttpSession session, Model model){
        if(session.getAttribute("user_email")==null){
            return "redirect:/login";
        }else{
            String user_email = (String)session.getAttribute("user_email");
            UserDto userDto = userService.selectOneUser(user_email);
            model.addAttribute("userDto",userDto);
            return "mypage_main.tiles";
        }

    }

}
