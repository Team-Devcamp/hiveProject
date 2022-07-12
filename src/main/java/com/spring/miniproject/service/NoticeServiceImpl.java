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

    @Override
    public int getCount() throws Exception {
        return noticeDao.count();
    }

    @Override
    public List<NoticeDto> getPage(Map map) throws Exception {
        return noticeDao.selectPage(map);
    }
    @Override
    public List<NoticeDto> selectList() throws Exception {
        return noticeDao.selectAll();
    }

    @Override
    public NoticeDto selectDetail(int notice_no) throws Exception {
        return noticeDao.selectDetail(notice_no);
    }
}
