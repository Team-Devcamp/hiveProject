package com.spring.miniproject.controller;

import com.google.gson.JsonObject;
import com.spring.miniproject.domain.*;
import com.spring.miniproject.service.CategoryService;
import com.spring.miniproject.service.ProductOptionService;
import com.spring.miniproject.service.ProductService;
import com.spring.miniproject.service.SubCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/productmanage")
public class ProductManageController {

    @Autowired
    ProductOptionService productOptionService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String productManagePage() {
        return "productManage.tiles";
    }
    //  상품 상위 옵션

    // 상품 상위 옵션 목록 불러오기
    @GetMapping("/productoption/list")
    @ResponseBody
    public ResponseEntity<List<ProductOptionDto>> getAllProductOptionList() {
        try {
            List<ProductOptionDto> productOptionList = productOptionService.selectAllProductOption();

            return new ResponseEntity<>(productOptionList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    // 상품 상위 옵션을 DB에 추가하기
    @PostMapping("/productoption/add")
    @ResponseBody
    public ResponseEntity<String> addProductOption(@RequestBody ProductOptionDto productOptionDto, Model m) {
        try {
            int rowCnt = productOptionService.insertProductOption(productOptionDto);

            if(rowCnt != 1) {
                throw new Exception("상품 상위옵션 추가에 실패했습니다.");
            }

            return new ResponseEntity<>("PRODUCTOPTION ADD SUCCESS", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTION ADD ERR", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/productoption/modify")
    @ResponseBody
    public ResponseEntity<String> modifyProductOption(@RequestBody ProductOptionDto productOptionDto, Model m) {
        try {
            int rowCnt = productOptionService.updateProductOption(productOptionDto);

            if(rowCnt != 1) {
                throw new Exception("상품 상위옵션 수정에 실패했습니다.");
            }

            return new ResponseEntity<>("PRODUCTOPTION MODIFY SUCCESS", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTION MODIFY ERR", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/productoption/delete")
    @ResponseBody
    public ResponseEntity<String> deleteProductOption(Integer option_id, Model m) {
        try {
            int rowCnt = productOptionService.deleteProductOption(option_id);

            if(rowCnt != 1) {
                throw new Exception("상품 상위옵션 삭제에 실패했습니다.");
            }

            return new ResponseEntity<>("PRODUCTOPTION DELETE SUCCESS", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTION DELETE ERR", HttpStatus.BAD_REQUEST);

        }
    }
    // 상품 등록하기
    @GetMapping("/registerproduct")
    public String registerProduct(Model m) {
        try {
            List<CategoryDto> categoryList = categoryService.selectAllCategory();
            List<SubCategoryDto> subCategoryList = subCategoryService.selectAllSubCategory();

            m.addAttribute("categoryList", categoryList);
            m.addAttribute("subCategoryList", subCategoryList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "productManage/registerProduct";
    }

    @PostMapping("/registerproduct")
    public String registerProduct(ProductDto productDto, Model m) {
        try {
            productDto.setProduct_thumb_nail("썸네일 임시 삽입");

            int rowCnt = productService.insertProduct(productDto);

            if(rowCnt != 1) {
                throw new Exception("상품 등록에 실패했습니다.");
            }

            return "redirect:/productmanage";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("productDto", productDto);
            return "productManage/registerProduct";
        }

    }


    @ResponseBody
    @RequestMapping(value = "/uploadimage")
    public void communityImageUpload(HttpServletRequest req, HttpServletResponse resp, MultipartHttpServletRequest multiFile) throws Exception{
        JsonObject jsonObject = new JsonObject();
        PrintWriter printWriter = null;
        OutputStream out = null;
        MultipartFile file = multiFile.getFile("upload");

        if(file != null) {
            if(file.getSize() >0 && StringUtils.isNotBlank(file.getName())) {
                if(file.getContentType().toLowerCase().startsWith("image/")) {
                    try{

                        String fileName = file.getOriginalFilename();
                        byte[] bytes = file.getBytes();

                        String uploadPath = req.getSession().getServletContext().getRealPath("/resources/image/product/productInfo"); //저장경로
                        System.out.println("uploadPath = " + uploadPath);

                        File uploadFile = new File(uploadPath);
                        if(!uploadFile.exists()) {
                            uploadFile.mkdir();
                        }
                        String fileName2 = UUID.randomUUID().toString();
                        uploadPath = uploadPath + "/" + fileName2 +fileName;
                        System.out.println("uploadPath = " + uploadPath);

                        out = new FileOutputStream(new File(uploadPath));
                        out.write(bytes);

                        printWriter = resp.getWriter();
                        String fileUrl = req.getContextPath() + "/image/product/productInfo/" +fileName2 +fileName; //url경로

                        System.out.println("fileUrl = " + fileUrl);
                        JsonObject json = new JsonObject();
                        json.addProperty("uploaded", 1);
                        json.addProperty("fileName", fileName);
                        json.addProperty("url", fileUrl);
                        printWriter.print(json);
                        System.out.println(json);

                    }catch(IOException e){
                        e.printStackTrace();
                    } finally {
                        if (out != null) {
                            out.close();
                        }
                        if (printWriter != null) {
                            printWriter.close();
                        }
                    }
                }


            }

        }
    }



}
