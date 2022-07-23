package com.spring.miniproject.controller;


import com.spring.miniproject.domain.UserProfileDto;
import com.spring.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;

@Controller
public class UserImageController {

    @Autowired
    private UserService userService;



    @RequestMapping("/mypage/image/add")
    public String addUserImage(){
        return "user/profile_image_upload";
    }


    // 마이페이지 프로필 이미지 업로드 메서드
    @ResponseBody
    @PostMapping("/mypage/image/upload")
    public String uploadImage(MultipartFile file, String user_email, HttpServletRequest request)throws Exception{
        // 원본 파일이 이미지 파일이 맞는지 확장자를 확인
        File checkFile = new File(file.getOriginalFilename());
        String type = Files.probeContentType(checkFile.toPath());
        // 프로젝트 root 경로 확인 -> 이미지 경로 잡기
        HttpSession session = request.getSession();
        String root_path = session.getServletContext().getRealPath("/");
        String uploadPath = root_path+"resources\\image\\user\\profile";
        // 이미지 파일이 아닐경우 실패
        if(!type.startsWith("image")){
            return "fail";
        }else{
            String fileName = user_email.substring(0,6) + "_profile.jpg";
            File uploadFile = new File(uploadPath, fileName);

            file.transferTo(uploadFile);

            String finalPath = "/image/user/profile/"+fileName;
            UserProfileDto userProfileDto = new UserProfileDto(user_email,finalPath);
            userService.updateProfileImage(userProfileDto);
            return "success";
        }

    }

    // 마이페이지 이미지 삭제 메서드
    @ResponseBody
    @PostMapping("/mypage/image/delete")
    public String deleteImage(String user_email,HttpServletRequest request){
        // 이미지 경로를 기본 이미지로 변경
        int result = userService.updateImageOrigin(user_email);
        // 현재 이미지의 경로를 지정
        // 프로젝트 root 경로 확인 -> 이미지 경로 잡기
        HttpSession session = request.getSession();
        String root_path = session.getServletContext().getRealPath("/");
        String uploadPath = root_path+"resources\\image\\user\\profile";
        String path = uploadPath+"\\"+user_email.substring(0,6)+"_profile.jpg";
        if(result==1){
            // 이미지를 삭제
            File file = new File(path);
            boolean flag = file.delete();
            return "success";
        }
        return "fail";
    }
}
