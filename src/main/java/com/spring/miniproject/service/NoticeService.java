package com.spring.miniproject.service;

import com.spring.miniproject.domain.NoticeDto;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    int getCount() throws Exception;

    List<NoticeDto> getPage(Map map) throws Exception;

    List<NoticeDto> selectList() throws Exception;

    NoticeDto selectDetail(int notice_no) throws Exception;
}
