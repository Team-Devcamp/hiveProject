package com.spring.miniproject.controller;

import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.service.FindPasswordService;
import com.spring.miniproject.service.MailCheckService;
import com.spring.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.URLEncoder;


@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private MailCheckService mailCheckService;

    @Autowired
    private FindPasswordService findPasswordService;

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("userDto",new UserDto());
        return "register_form";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register_form";
        }else{
            // 비밀번호 암호화 인코딩
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            // 비밀번호를 암호화하여 UserDto password에 새로운 비밀번호를 저장
            String secure_pwd = encoder.encode(userDto.getUser_password());
            userDto.setUser_password(secure_pwd);
            userService.insertUser(userDto);
        }
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping("/register/delete")
    public String deleteUser(String user_email,HttpSession session){
        int rowCnt = userService.deleteOneUser(user_email);

        if(rowCnt==1){
            session.invalidate();
            return "success";
        }
        return "fail";
    }

    @RequestMapping("register/mailCheckPop")
    public String mailCheckPop(){
        return "email_check_form";
    }

    @RequestMapping(value = "register/emailCheck", method = RequestMethod.GET)
    @ResponseBody
    public String mailCheck(String user_email) throws Exception{
        UserDto userDto = userService.selectOneUser(user_email);
        if(userDto!=null){
            return "overlap";
        }
        return mailCheckService.mailCheck(user_email);
    }

    @RequestMapping ("register/findPassword")
    public String findPassword(){
        return "find_pwd_form";
    }

    @RequestMapping(value = "register/findPassword/check", method = RequestMethod.GET)
    @ResponseBody
    public String findPassword(String user_email) throws Exception{
        UserDto userDto = userService.selectOneUser(user_email);
        if(userDto!=null){
            return findPasswordService.mailCheck(user_email);
        }else{
            return "fail";
        }

    }

    @RequestMapping("register/findPassword/save")
    @ResponseBody
    public String findPasswordSave(String user_email) throws Exception{
        String tempPassword = findPasswordService.tempPassword();
        UserDto userDto = new UserDto(user_email,tempPassword);
        int rowCnt = userService.updateUserPassword(userDto);
        if(rowCnt==1){
            findPasswordService.sendNewPassword(user_email,tempPassword);
            return "success";
        }
        return "error";
    }

}
