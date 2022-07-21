package com.spring.miniproject.controller;

import com.google.gson.JsonObject;
import com.spring.miniproject.domain.*;
import com.spring.miniproject.service.*;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/productmanage")
public class ProductManageController {

    @Autowired
    private ProductOptionService productOptionService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductOptionDetailService productOptionDetailService;
    @Autowired
    private ProductStockService productStockService;

    // 상품관리 페이지로 이동하는 메서드
    @GetMapping("")
    public String productManagePage(ProductSearchCondition psc, Model m, HttpServletRequest request) {
        if(!adminCheck(request)) {
            return "redirect:/login";
        }

        try {
            Integer totalCnt = productService.selectSearchProductCnt(psc);
            m.addAttribute("totalCnt", totalCnt);

            ProductPageHandler productPageHandler = new ProductPageHandler(totalCnt, psc);
            m.addAttribute("pph", productPageHandler);

            List<ProductDto> productList = productService.selectSearchProduct(psc);
            m.addAttribute("productList", productList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "productManage/productManage.tiles";
    }


    // 상품 상위 옵션 목록 불러오기
    @GetMapping("/productoption/list")
    @ResponseBody
    public ResponseEntity<List<ProductOptionDto>> getAllProductOptionList(Integer product_id) {
        try {
            List<ProductOptionDto> productOptionList = productOptionService.selectAllProductOption(product_id);

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

    // 상품 상위옵션 수정
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

    // 상품 상위옵션 삭제
    @PostMapping("/productoption/delete")
    @ResponseBody
    public ResponseEntity<String> deleteProductOption(Integer option_id) {
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
    // 상품 등록하는 form으로 이동
    @GetMapping("/product/register")
    public String registerProduct(Model m) {
        try {
            List<CategoryDto> categoryList = categoryService.selectAllCategory();
            List<SubCategoryDto> subCategoryList = subCategoryService.selectAllSubCategory();
            m.addAttribute("mode", "new");
            m.addAttribute("categoryList", categoryList);
            m.addAttribute("subCategoryList", subCategoryList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "productManage/registerProduct";
    }

    // 상품을 DB에 등록
    @PostMapping("/product/register")
    public String registerProduct(ProductDto productDto, Model m, RedirectAttributes rattr) {
        try {

//            System.out.println("productDto.getProduct_thumb_nail() = " + productDto.getProduct_thumb_nail());
            int rowCnt = productService.insertProduct(productDto);

            if(rowCnt != 1) {
                throw new Exception("상품 등록에 실패했습니다.");
            }
            rattr.addFlashAttribute("msg", "REG_OK");
            return "redirect:/productmanage";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("productDto", productDto);
            m.addAttribute("msg", "REG_ERR");
            return "productManage/registerProduct";
        }

    }

    // 텍스트 편집기에 img 파일 업로드 하는 메서드
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
                        uploadPath = uploadPath + "/" + fileName2 + "_" + fileName;
                        System.out.println("uploadPath = " + uploadPath);

                        out = new FileOutputStream(new File(uploadPath));
                        out.write(bytes);

                        printWriter = resp.getWriter();
                        String fileUrl = req.getContextPath() + "/image/product/productInfo/" +fileName2 + "_" + fileName; //url경로

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
    // 썸네일 업로드하는 메서드
    @PostMapping(value="/uploadThumbnail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<AttachImageDto>> uploadAjaxActionPOST(MultipartFile[] uploadFile) {

        /* 이미지 파일 체크 */
        for(MultipartFile multipartFile: uploadFile) {

            File checkfile = new File(multipartFile.getOriginalFilename());
            String type = null;

            try {
                type = Files.probeContentType(checkfile.toPath());

            } catch (IOException e) {
                e.printStackTrace();
            }

            if(!type.startsWith("image")) {

                List<AttachImageDto> list = null;
                return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);

            }

        }// for
        
        String uploadFolder = "C:\\hive\\target\\miniproject-1.0.0-BUILD-SNAPSHOT\\resources\\image\\product\\thumbnail";

//        // 날짜 가져오기
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        String str = sdf.format(date);
//        String datePath = str.replace("-", File.separator);

        /* 폴더 생성 */
        File uploadPath = new File(uploadFolder);

        if(uploadPath.exists() == false) {
            uploadPath.mkdirs();
        }

        List<AttachImageDto> list = new ArrayList<>();

        for(MultipartFile multipartFile : uploadFile) {
            /* 이미지 정보 객체 생성 */
            AttachImageDto dto = new AttachImageDto();

            /* 파일 이름 */
            String uploadFileName = multipartFile.getOriginalFilename();
            dto.setFileName(uploadFileName);
//            dto.setUploadPath(datePath);

            /* uuid 적용 파일 이름 */
            String uuid = UUID.randomUUID().toString();
            uploadFileName = uuid + "_" + uploadFileName;
            dto.setUuid(uuid);

            /* 파일 위치, 파일 이름을 합친 File 객체 */
            File saveFile = new File(uploadPath, uploadFileName);

            /* 파일 저장 */
            try {
                multipartFile.transferTo(saveFile);

                File thumbnailFile = new File(uploadPath, "thumb_" + uploadFileName);

                BufferedImage bo_image = ImageIO.read(saveFile);

                //비율
                double ratio = 3;
                //넓이 높이
                int width = (int) (bo_image.getWidth() / ratio);
                int height = (int) (bo_image.getHeight() / ratio);


                Thumbnails.of(saveFile)
                        .size(width, height)
                        .toFile(thumbnailFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

            list.add(dto);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 썸네일을
    @GetMapping("/displayThumbnail")
    public ResponseEntity<byte[]> getImage(String fileName){
        File file = new File("C:\\hive\\target\\miniproject-1.0.0-BUILD-SNAPSHOT\\resources\\image\\product\\thumbnail\\" + fileName);

        ResponseEntity<byte[]> result = null;

        try {

            HttpHeaders header = new HttpHeaders();

            header.add("Content-type", Files.probeContentType(file.toPath()));

            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

        }catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }
    /* 썸네일 파일 삭제(원본, 축소본) */
    @PostMapping("/deleteThumbnail")
    public ResponseEntity<String> deleteFile(String fileName){
        File file = null;

        try {
            // 썸네일 파일 삭제
            file = new File("C:\\hive\\target\\miniproject-1.0.0-BUILD-SNAPSHOT\\resources\\image\\product\\thumbnail\\" + URLDecoder.decode(fileName, "UTF-8"));

            file.delete();

            // 원본 파일 삭제
            String originFileName = file.getAbsolutePath().replace("thumb_", "");

            file = new File(originFileName);

            file.delete();
        } catch(Exception e) {

            e.printStackTrace();

            return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);

        }
        return new ResponseEntity<>("success", HttpStatus.OK);
    }


    // 상품을 삭제하는 메서드
    @PostMapping("/product/delete")
    public String deleteProduct(Integer product_id, RedirectAttributes rattr) {
        try {
            int rowCnt = productService.deleteProduct(product_id);
            if(rowCnt != 1) {
                throw new Exception("상품 삭제에 실패했습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }
        rattr.addFlashAttribute("msg", "DEL_OK");
        return "redirect:/productmanage";
    }

    // 상품 수정하는 form을 보여주는 메서드
    @PostMapping("/product/modify")
    public String modifyProduct(Integer product_id, Model m) {
        try {
            ProductDto productDto = productService.selectProduct(product_id);
            m.addAttribute("productDto", productDto);

            List<CategoryDto> categoryList = categoryService.selectAllCategory();
            List<SubCategoryDto> subCategoryList = subCategoryService.selectAllSubCategory();

            m.addAttribute("categoryList", categoryList);
            m.addAttribute("subCategoryList", subCategoryList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "productManage/registerProduct";
    }

    // 상품 수정form을 제출하는 메서드
    @PostMapping("/product/submitmod")
    public String submitModifyProduct(ProductDto productDto, Model m, RedirectAttributes rattr) {
        try {

            int rowCnt = productService.updateProduct(productDto);
            if(rowCnt != 1) {
                throw new Exception("상품 수정에 실패했습니다.");
            }
            rattr.addFlashAttribute("msg", "MOD_OK");
            return "redirect:/productmanage";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("productDto", productDto);
            m.addAttribute("msg", "MOD_ERR");
            return "productManage/registerProduct";
        }
    }

    // 하위옵션 리스트를 보여주는 메서드
    @GetMapping("/productoptiondetail")
    @ResponseBody
    public ResponseEntity<List<ProductOptionDetailDto>> getProductOptionDetailList(Integer product_id, Integer option_id) {
        try {
            List<ProductOptionDetailDto> productOptionDetailDtoList = productOptionDetailService.selectSpecificProductOptionDetail(product_id, option_id);

            return new ResponseEntity<>(productOptionDetailDtoList, HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    // 하위옵션을 추가하는 메서드
    @PostMapping("/productoptiondetail/add")
    @ResponseBody
    public ResponseEntity<String> addProductOptionDetail(@RequestBody ProductOptionDetailDto productOptionDetailDto) {
        try {

            int rowCnt = productOptionDetailService.insertProductOptionDetail(productOptionDetailDto);

            if(rowCnt != 1) {
                throw new Exception("하위 옵션 등록에 실패했습니다.");
            }

            return new ResponseEntity<>("PRODUCTOPTIONDETAIL ADD SUCCESS", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTIONDETAIL ADD ERR", HttpStatus.BAD_REQUEST);
        }
    }
    // 하위 옵션을 수정하는 메서드
    @PostMapping("/productoptiondetail/modify")
    @ResponseBody
    public ResponseEntity<String> modifyProductOptionDetail(@RequestBody ProductOptionDetailDto productOptionDetailDto) {
        try {
            int rowCnt = productOptionDetailService.updateProductOptionDetail(productOptionDetailDto);
            if(rowCnt != 1) {
                throw new Exception("하위옵션 수정에 실패했습니다.");
            }
            return new ResponseEntity<>("PRODUCTOPTIONDETAIL MODIFY SUCCESS", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTIONDETAIL MODIFY ERR", HttpStatus.BAD_REQUEST);
        }
    }
    // 하위옵션을 삭제하는 메서드
    @PostMapping("/productoptiondetail/delete")
    @ResponseBody
    public ResponseEntity<String> deleteProductOptionDetail(Integer option_detail_id) {
        try {
            int rowCnt = productOptionDetailService.deleteProductOptionDetail(option_detail_id);
            if(rowCnt != 1) {
                throw new Exception("하위옵션 삭제에 실패했습니다.");
            }
            return new ResponseEntity<>("PRODUCTOPTIONDETAIL DELETE SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTIONDETAIL DELETE ERR", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/productstock")
    @ResponseBody
    public ResponseEntity<ProductStockDto> getProductStock(@RequestBody ProductStockDto productStockDto) {
        try {
            ProductStockDto productStock = productStockService.selectProductStock(productStockDto);

            return new ResponseEntity<>(productStock, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private boolean adminCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 관리자 id와 일치하는지 확인, 일치하면 true를 반환
        return ("admin@hive.co.kr").equals(session.getAttribute("user_email"));
    }

}
