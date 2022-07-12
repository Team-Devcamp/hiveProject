package com.spring.miniproject.dao;

import com.spring.miniproject.domain.NoticeDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class NoticeDaoImpl implements NoticeDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.spring.miniproject.dao.NoticeMapper.";

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
    public List<NoticeDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace+"selectPage", map);
    }

    @Override
    public List<NoticeDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public NoticeDto selectDetail(int notice_no) throws Exception {
        return session.selectOne(namespace+"selectDetail", notice_no);
    }

}
