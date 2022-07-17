package com.spring.miniproject.service;

import com.spring.miniproject.domain.QnaDto;
import com.spring.miniproject.domain.QnaPaging;

import java.util.List;
import java.util.Map;

public interface QnaService {
    public int insertQna(QnaDto dto) throws Exception;

    public int deleteQna(int product_id, int qna_id, String writer) throws Exception;

    public Map<String, Object> selectQnaList(Integer product_id, String pg) throws Exception;

    public QnaDto selectQna(Integer product_id, Integer qna_id) throws Exception;

    public int countQna(Integer product_id) throws Exception;

}
