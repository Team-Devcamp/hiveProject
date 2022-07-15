package com.spring.miniproject.controller;

import com.spring.miniproject.domain.QnaDto;
import com.spring.miniproject.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ResponseBody
    public void insertQna(@RequestBody QnaDto dto, HttpSession session){

//        String writer = (String)session.getAttribute("id");
        System.out.println("등록컨트롤??");

        int product_id = 1;
        dto.setWriter("asdf@gmail.com");
        dto.setProduct_id(product_id);

        System.out.println("큐앤애이write product_id= " + product_id + " "+ dto.getQna_title());
        qnaService.insertQna(dto);
    }

    @PostMapping("/delete")
    public void deleteQna(@RequestParam int qna_id, int product_id, HttpSession session){
        System.out.println("product_id = " + qna_id+"  product_id = "+ product_id);
        String writer = "asdf@gmail.com";

        qnaService.deleteQna(product_id, qna_id, writer);
    }

    //상품별 qna목록
    @GetMapping(value="/list/product")
    @ResponseBody
    public Map<String,Object> selectQnaList(@RequestParam int product_id){
        List<QnaDto> list = qnaService.selectQnaList(product_id);
        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }

    @GetMapping("/count")
    @ResponseBody
    public int countQna(){
        return qnaService.countQna();
    }

}
