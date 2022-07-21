package com.spring.miniproject.controller;

import com.spring.miniproject.domain.*;
import com.spring.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyPageController {

    @Autowired
    UserService userService;

    // 사진이 업로드되는 경로
    private String uploadPath = "C:\\Users\\ch457\\IdeaProjects\\hiveProject\\src\\main\\webapp\\resources\\image\\user\\product_review";

    // 사진 삭제 기본 경로
    private String deletePath = "C:\\Users\\ch457\\IdeaProjects\\hiveProject\\src\\main\\webapp\\resources";

    // 마이 페이지 이동 메서드
    @RequestMapping("/mypage")
    public String myPage(HttpSession session, Model model){
        if(session.getAttribute("user_email")==null){
            return "redirect:/login";
        }else{
            String user_email = (String)session.getAttribute("user_email");
            UserDto userDto = userService.selectOneUser(user_email);
            model.addAttribute("userDto",userDto);
            return "user/mypage_main.tiles";
        }

    }

    // 마이페이지 내부 주소록을 보여주는 메서드
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
            return "user/mypage_address_list.tiles";
        }else{
            return "user/mypage_address.tiles";
        }

    }

    @RequestMapping("mypage/address/insert")
    public String insertAddress(){
        return "user/insert_address";
    }

    // 주소록을 저장하는 메서드
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
    
    // 주소록을 삭제하는 메서드
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
        return "user/modify_address";
    }

    // 주소록을 수정하는 메서드
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
    
    // 구매내역을 보여주는 메서드
    @RequestMapping("mypage/purchase")
    public String myPurchase(HttpSession session,Model model,@RequestParam(defaultValue = "1") int page){
        String user_email = (String)session.getAttribute("user_email");
        Integer user_id = userService.selectUserId(user_email);
        Integer purchaseCnt = userService.selectUserPurchaseCnt(user_id);
        PageHandlerDto pageHandlerDto = new PageHandlerDto(purchaseCnt,page,user_id,4,4);
        List<UserPurchaseDto> purchaseList = userService.selectUserPurchase(pageHandlerDto);
        List<ProductReviewDto> reviewDtoList = userService.selectUserProductReview(pageHandlerDto);
        model.addAttribute("review_list",reviewDtoList);
        model.addAttribute("purchase_list",purchaseList);
        model.addAttribute("paging",pageHandlerDto);
        return "user/mypage_purchase.tiles";
    }

    // 구매 리뷰를 작성하는 메서드
    @ResponseBody
    @PostMapping ("mypage/purchase/review/insert")
    public String myPurchaseReview(MultipartFile file, String user_email, Integer user_id, Integer product_id, Integer purchase_id,String review_content) throws Exception{
        // 원본 파일이 이미지 파일이 맞는지 확장자를 확인
        File checkFile = new File(file.getOriginalFilename());
        String type = Files.probeContentType(checkFile.toPath());
        // 이미지 파일이 아닐경우 실패
        if(!type.startsWith("image")){
            return "fail";
        }else{
            int random = (int)(Math.random()*200)+1;
            String fileName = user_email.substring(0,6)+ random + "_product_review.jpg";
            File uploadFile = new File(uploadPath, fileName);
            file.transferTo(uploadFile);
            String finalPath = "/image/user/product_review/"+fileName;
            ProductReviewDto productReviewDto = new ProductReviewDto(purchase_id,user_id,product_id,user_email,review_content,finalPath);
            int result = userService.insertUserProductReview(productReviewDto);
            if(result==1){
                return "success";
            }else {
                return "fail";
            }

        }
    }

    // 구매 리뷰를 수정하는 메서드
    @ResponseBody
    @PostMapping ("mypage/purchase/review/modify")
    public String reviewModify(MultipartFile file, Integer user_id,Integer purchase_id,String review_content,int product_id,String user_email) throws Exception{
        Map map = new HashMap();
        map.put("user_id",user_id);
        map.put("purchase_id",purchase_id);
        String upload_file = userService.selectUserReviewImage(map);
        upload_file = upload_file.replaceAll("/","\\\\");
        String path = deletePath+upload_file;
        File pastFile = new File(path);
        pastFile.delete();
        // 원본 파일이 이미지 파일이 맞는지 확장자를 확인
        File checkFile = new File(file.getOriginalFilename());
        String type = Files.probeContentType(checkFile.toPath());
        // 이미지 파일이 아닐경우 실패
        if(!type.startsWith("image")){
            return "fail";
        }else{
            int random = (int)(Math.random()*200)+1;
            String fileName = user_email.substring(0,6)+ random + "_product_review.jpg";
            File uploadFile = new File(uploadPath, fileName);
            file.transferTo(uploadFile);
            String finalPath = "/image/user/product_review/"+fileName;
            ProductReviewDto productReviewDto = new ProductReviewDto(review_content,finalPath,user_id,purchase_id,product_id);
            int result = userService.updateUserProductReview(productReviewDto);
            if(result==1){
                return "success";
            }else {
                return "fail";
            }

        }
    }

    @GetMapping("mypage/purchase/review/insert")
    public String myPurchaseReview(){
        return "user/review_upload";
    }

    @GetMapping("mypage/purchase/review/modify")
    public String myPurchaseReviewModify(){
        return "user/review_modify";
    }

    // 구매리뷰를 삭제하는 메서드
    @RequestMapping("mypage/purchase/review/delete")
    public String myPurchaseReviewDelete(RedirectAttributes redirectAttributes, Integer user_id, Integer purchase_id,Integer product_id){
        ProductReviewDto productReviewDto = new ProductReviewDto(user_id,purchase_id,product_id);
        Map map = new HashMap();
        map.put("user_id",user_id);
        map.put("purchase_id",purchase_id);
        String upload_file = userService.selectUserReviewImage(map);
        upload_file = upload_file.replaceAll("/","\\\\");
        String path = deletePath+upload_file;
        File pastFile = new File(path);
        pastFile.delete();
        int result = userService.deleteUserProductReview(productReviewDto);

        if(result==1){
            redirectAttributes.addFlashAttribute("success_msg","삭제에 성공했습니다.");
            return "redirect:/mypage/purchase";
        }else{
            redirectAttributes.addFlashAttribute("error_msg","삭제에 실패했습니다.");
            return "redirect:/mypage/purchase";
        }
    }


}


