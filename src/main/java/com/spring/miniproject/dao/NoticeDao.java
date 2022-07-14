package com.spring.miniproject.dao;

import com.spring.miniproject.domain.NoticeDto;

import java.util.List;
import java.util.Map;

public interface NoticeDao {
    int count() throws Exception; // 페이징 관련

    List<NoticeDto> selectPage(Map map) throws Exception; // 페이징 관련

    List<NoticeDto> selectAll() throws Exception; // 목록

    NoticeDto selectDetail(int notice_id) throws Exception; // 상세

    void insertNotice(NoticeDto noticeDto) throws Exception; // 등록

    void updateNotice(NoticeDto noticeDto) throws Exception; // 수정

    void deleteNotice(int notice_id) throws Exception; // 삭제

    void viewCount(int notice_id) throws Exception; // 조회수 증가
}
