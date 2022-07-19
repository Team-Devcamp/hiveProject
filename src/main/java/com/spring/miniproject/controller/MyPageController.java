package com.spring.miniproject.controller;

import com.spring.miniproject.domain.PageHandlerDto;
import com.spring.miniproject.domain.UserAddressDto;
import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String addressList(HttpSession session,Model model,@RequestParam(defaultValue = "1") int page){
        String user_email = (String)session.getAttribute("user_email");
        int user_id = userService.selectUserId(user_email);
        int userAddressCnt = userService.selectUserAddressCnt(user_id);
        PageHandlerDto pageHandlerDto = new PageHandlerDto(userAddressCnt,page,user_id);
        List<UserAddressDto> addressList = userService.selectAddressList(pageHandlerDto);
        if(userAddressCnt !=0){
            model.addAttribute("address_list",addressList);
            model.addAttribute("paging",pageHandlerDto);
            return "mypage_address_list.tiles";
        }else{
            return "mypage_address.tiles";
        }

    }

    @RequestMapping("mypage/address/insert")
    public String insertAddress(){
        return "insert_address";
    }

    @ResponseBody
    @PostMapping("mypage/address/save")
    public String saveAddress(HttpSession session,String user_name,String user_phone,String post_number,String address,String detail_address){
        String user_email = (String)session.getAttribute("user_email");
        int user_id = userService.selectUserId(user_email);
        UserAddressDto userAddressDto = new UserAddressDto(user_id,user_name,user_phone,address,detail_address,post_number);
        int result = userService.insertUserAddress(userAddressDto);
        if(result==1){
            return "success";
        }else{
            return "fail";
        }
    }

    @RequestMapping("mypage/address/delete")
    public String deleteAddress(Integer address_id, RedirectAttributes redirectAttributes){
        int result = userService.deleteUserAddress(address_id);
        if(result == 1){
            redirectAttributes.addFlashAttribute("success_msg","삭제에 성공했습니다.");
            return "redirect:/mypage/address/list";
        }else{
            redirectAttributes.addAttribute("error_msg","삭제에 실패했습니다.");
            return "redirect:/mypage/address/list";
        }

    }

    @GetMapping("mypage/address/modify")
    public String modifyAddress(Integer address_id,Model model){
        model.addAttribute("address_id",address_id);
        return "modify_address";
    }

    @ResponseBody
    @PostMapping("mypage/address/modify/save")
    public String modifyAddress(HttpSession session,String user_name,String user_phone,String post_number,String address,String detail_address,int address_id){
        String user_email = (String)session.getAttribute("user_email");
        Integer user_id = userService.selectUserId(user_email);
        UserAddressDto userAddressDto = new UserAddressDto(address_id,user_id,user_name,user_phone,address,detail_address,post_number);
        int result = userService.updateUserAddress(userAddressDto);
        if(result==1){
            return "success";
        }else{
            return "fail";
        }
    }
}
