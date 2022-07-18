package com.spring.miniproject.service;

import com.spring.miniproject.domain.QnaDto;

import java.util.List;

public interface QnaService {
    public void insertQna(QnaDto dto);

    public void deleteQna(int product_id, int qna_id, String writer);

    public List<QnaDto> selectQnaList(Integer product_id);

    public int countQna();


}
