package com.spring.miniproject.controller;

import com.spring.miniproject.domain.QnaDto;
import com.spring.miniproject.domain.QnaPaging;
import com.spring.miniproject.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/qna")
public class QnaController {
    @Autowired
    private QnaService qnaService;

    @PostMapping("/write")
    public ResponseEntity<String> insertQna(@RequestBody QnaDto qnaDto, @RequestParam int product_id, HttpSession session){
      String writer = (String)session.getAttribute("user_email");
        qnaDto.setProduct_id(product_id);
        qnaDto.setWriter(writer);

        try {
            int rowCnt = qnaService.insertQna(qnaDto);

            if(rowCnt != 1) {
                throw new Exception("글 등록에 실패했습니다.");
            }
            return new ResponseEntity<>("빠른 답변 드리겠습니다!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTION ADD ERR", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteQna(@RequestParam int qna_id, int product_id, HttpSession session){
        System.out.println("product_id = " + qna_id+"  product_id = "+ product_id);
        String writer = "asdf@gmail.com";

        try {
            int rowCnt = qnaService.deleteQna(product_id, qna_id, writer);

            if(rowCnt != 1){
                throw new Exception("글 삭제에 실패했습니다.");
            }
            return new ResponseEntity<>("PRODUCTOPTION DELETE SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("PRODUCTOPTION DELETE ERR", HttpStatus.BAD_REQUEST);
        }
    }

    //상품별 qna목록
    @GetMapping(value="/list/product")
    @ResponseBody
    public Map<String,Object> selectQnaList(@RequestParam int product_id,
                                            @RequestParam(required = false, defaultValue="1") String pg){
        Map<String,Object> map = null;
        try {
            map = qnaService.selectQnaList(product_id, pg);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @GetMapping("/count")
    @ResponseBody
    public int countQna(@RequestParam Integer product_id) throws Exception{
        return qnaService.countQna(product_id);
    }


}
