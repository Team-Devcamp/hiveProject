package com.spring.miniproject.dao;

import com.spring.miniproject.domain.QnaDto;

import java.util.List;
import java.util.Map;

public interface QnaDao {
    public int insertQna(QnaDto dto) throws Exception;

    public List<QnaDto> selectQnaList(Map<String, Integer> map) throws Exception;

    public int countQna(Integer product_id) throws Exception;

    public int deleteQna(Map<String, Object> map) throws Exception;

    public QnaDto selectQna(Map map) throws Exception;
}
