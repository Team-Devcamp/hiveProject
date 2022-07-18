package com.spring.miniproject.controller;

import com.spring.miniproject.domain.UserAddressDto;
import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping("/mypage/address/list")
    public String addressList(HttpSession session,Model model){
        String user_email = (String)session.getAttribute("user_email");
        int user_id = userService.selectUserId(user_email);
        int address_count = userService.selectUserAddressCnt(user_id);
        List<UserAddressDto> addressList = userService.selectUserAddress(user_id);
        if(address_count !=0){
            model.addAttribute("address_list",addressList);
            return "mypage_address_list.tiles";
        }else{
            return "mypage_address.tiles";
        }

    }

    @RequestMapping("mypage/address/insert")
    public String insertAddress(){
        return "insert_address";
    }

    @PostMapping("mypage/address/save")
    public String saveAddress(HttpSession session,String user_name,String user_phone,String post_number,String address,String detail_address){
        String user_email = (String)session.getAttribute("user_email");
        int user_id = userService.selectUserId(user_email);
        UserAddressDto userAdressDto = new UserAddressDto(user_id,user_name,user_phone,address,detail_address,post_number);
        int result = userService.insertUserAddress(userAdressDto);
        return "redirect:/mypage/address/list";
    }

    @RequestMapping("mypage/address/delete")
    public String deleteAddress(Integer address_id){
        int result = userService.deleteUserAddress(address_id);
        return "redirect:/mypage/address/list";
    }

    @GetMapping("mypage/address/modify")
    public String modifyAddress(Integer address_id,Model model){
        model.addAttribute("address_id",address_id);
        return "modify_address";
    }


    @PostMapping("mypage/address/modify/save")
    public String modifyAddress(HttpSession session,String user_name,String user_phone,String post_number,String address,String detail_address){
        String user_email = (String)session.getAttribute("user_email");
        Integer user_id = userService.selectUserId(user_email);
        UserAddressDto userAddressDto = new UserAddressDto(user_id,user_name,user_phone,address,detail_address,post_number);
        int result = userService.updateUserAddress(userAddressDto);
        return "redirect:/mypage/address/list";
    }
}
