package com.spring.miniproject.service;

import com.spring.miniproject.dao.NoticeDao;
import com.spring.miniproject.domain.NoticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    NoticeDao noticeDao;

    // 페이징 관련 총 게시물 조회
    @Override
    public int getCount() throws Exception {
        return noticeDao.count();
    }

    // 페이징 관련
    @Override
    public List<NoticeDto> getPage(Map map) throws Exception {
        return noticeDao.selectPage(map);
    }

    // 조회
    @Override
    public List<NoticeDto> selectList() throws Exception {
        return noticeDao.selectAll();
    }

    // 상세
    @Override
    public NoticeDto selectDetail(int notice_id) throws Exception {
        return noticeDao.selectDetail(notice_id);
    }

    // 등록
    @Override
    public void insertNotice(NoticeDto noticeDto) throws Exception {
        noticeDao.insertNotice(noticeDto);
    }

    // 수정
    @Override
    public void updateNotice(NoticeDto noticeDto) throws Exception {
        noticeDao.updateNotice(noticeDto);
    }

    // 삭제
    @Override
    public void deleteNotice(int notice_id) throws Exception {
        noticeDao.deleteNotice(notice_id);
    }

    // 조회수 증가
    @Override
    public void viewCount(int notice_id) throws Exception {
        noticeDao.viewCount(notice_id);
    }
}
