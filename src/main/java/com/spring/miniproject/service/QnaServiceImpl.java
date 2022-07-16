package com.spring.miniproject.service;

import com.spring.miniproject.dao.QnaDao;
import com.spring.miniproject.domain.QnaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QnaServiceImpl implements QnaService {
    @Autowired
    private QnaDao qnaDao;

    @Override
    public void insertQna(QnaDto dto) {
        
        qnaDao.insertQna(dto);
    }

    @Override
    public void deleteQna(int product_id, int qna_id, String writer) {
        Map<String, Object> map = new HashMap<>();
        map.put("product_id", product_id);
        map.put("qna_id", qna_id);
        map.put("writer",writer);

        qnaDao.deleteQna(map);
    }

    @Override
    public List<QnaDto> selectQnaList(Integer product_id) {
        System.out.println("서비스product_id = " + product_id);
        return qnaDao.selectQnaList(product_id);
    }

    @Override
    public int countQna() {
        
        return qnaDao.countQna();
    }


}
