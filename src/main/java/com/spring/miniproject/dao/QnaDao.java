package com.spring.miniproject.dao;

import com.spring.miniproject.domain.QnaDto;

import java.util.List;
import java.util.Map;

public interface QnaDao {
    public void insertQna(QnaDto dto);

    public List<QnaDto> selectQnaList(Integer product_id);

    public int countQna();

    public void deleteQna(Map<String, Object> map);
}
