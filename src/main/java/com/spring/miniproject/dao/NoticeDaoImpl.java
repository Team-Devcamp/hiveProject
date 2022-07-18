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

    // 페이징 관련 총 게시물 조회
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    // 페이징 관련
    @Override
    public List<NoticeDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace+"selectPage", map);
    }

    // 조회
    @Override
    public List<NoticeDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }

    // 상세
    @Override
    public NoticeDto selectDetail(int notice_id) throws Exception {
        return session.selectOne(namespace+"selectDetail", notice_id);
    }

    // 등록
    @Override
    public void insertNotice(NoticeDto noticeDto) throws Exception {
        session.insert(namespace+"noticeWrite", noticeDto);
    }

    // 수정
    @Override
    public void updateNotice(NoticeDto noticeDto) throws Exception {
        session.update(namespace+"updateNotice", noticeDto);
    }

    // 삭제
    @Override
    public void deleteNotice(int notice_id) throws Exception {
        session.delete(namespace+"deleteNotice", notice_id);
    }

    // 조회수 증가
    @Override
    public void viewCount(int notice_id) throws Exception {
        session.update(namespace+"viewCount", notice_id);
    }
}
