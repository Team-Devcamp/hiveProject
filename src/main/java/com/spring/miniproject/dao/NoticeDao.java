package com.spring.miniproject.dao;

import com.spring.miniproject.domain.NoticeDto;

import java.util.List;
import java.util.Map;

public interface NoticeDao {
    int count() throws Exception;

    List<NoticeDto> selectPage(Map map) throws Exception;

    List<NoticeDto> selectAll() throws Exception;

    NoticeDto selectDetail(int notice_no) throws Exception;
}
