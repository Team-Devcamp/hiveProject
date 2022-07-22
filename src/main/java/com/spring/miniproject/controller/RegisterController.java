package com.spring.miniproject.controller;

import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.service.FindPasswordService;
import com.spring.miniproject.service.MailCheckService;
import com.spring.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


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
        return "user/register_form.tiles";
    }

    // 회원 가입 메서드(유효성 검사 및, 비밀번호 암호화 기능 포함(BCryptPasswordEncoder 사용)
    @PostMapping("/register")
    public String registerUser(@Valid UserDto userDto, BindingResult bindingResult,String check_email,Model model){

        if(check_email.equals("true")){
            model.addAttribute("email_check",check_email);
        }
        if(bindingResult.hasErrors()){
            return "user/register_form.tiles";
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

    // 회원 탈퇴 메서드
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
        return "user/email_check_form";
    }

    // 이메일 인증 메서드
    @GetMapping( "register/emailCheck")
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
        return "user/find_pwd_form";
    }

    // 비밀번호 찾기 메서드(이메일로 user를 조회 후 해당하는 회원이 있을때만 통과시킨다)
    @GetMapping("register/findPassword/check")
    @ResponseBody
    public String findPassword(String user_email) throws Exception{
        UserDto userDto = userService.selectOneUser(user_email);
        if(userDto!=null){
            return findPasswordService.mailCheck(user_email);
        }else{
            return "fail";
        }

    }

    @RequestMapping("/register/findId")
    public String findId(){
        return "/user/find_id_form";
    }

    @ResponseBody
    @PostMapping("/register/findId/save")
    public String findIdSave(String user_name,String user_phone){
        System.out.println(user_name + " " + user_phone);
        Map map = new HashMap();
        map.put("user_name",user_name);
        map.put("user_phone",user_phone);
        String user_email = userService.selectUserEmail(map);
        if(user_email != null && user_email != ""){
            return user_email;
        }else{
            return "fail";
        }
    }


    // 비밀번호 찾기 메서드(이메일 인증을 통과하면 임시비밀번호를 발급해준다)
    @RequestMapping("register/findPassword/save")
    @ResponseBody
    public String findPasswordSave(String user_email) throws Exception{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String tempPassword = findPasswordService.tempPassword();
        String securePassword = encoder.encode(tempPassword);
        UserDto userDto = new UserDto(user_email,securePassword);
        int rowCnt = userService.updateUserPassword(userDto);
        if(rowCnt==1){
            findPasswordService.sendNewPassword(user_email,tempPassword);
            return "success";
        }
        return "error";
    }


}
