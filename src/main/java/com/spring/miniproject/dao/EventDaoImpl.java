package com.spring.miniproject.dao;

import com.spring.miniproject.domain.EventDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EventDaoImpl implements EventDao {

    @Autowired
    private SqlSession session;

    private String namespace = "com.spring.miniproject.dao.EventMapper.";

    @Override
    public List<EventDto> selectAllEvent() throws Exception {
        return session.selectList(namespace+"selectAllEvent");
    }

    @Override
    public EventDto selectEvent(Integer event_id) throws Exception {
        return session.selectOne(namespace+"selectEvent", event_id);
    }

    @Override
    public int countEvent() throws Exception {
        return session.selectOne(namespace+"countEvent");
    }

    @Override
    public int deleteEvent(Integer event_id) throws Exception {
        return session.delete(namespace+"deleteEventForAdmin", event_id);
    }

    @Override
    public int insertEvent(EventDto eventDto) throws Exception {
        return session.insert(namespace+"insertEvent", eventDto);
    }

    @Override
    public int updateEvent(EventDto eventDto) throws Exception {
        return session.update(namespace+"updateEvent", eventDto);
    }

    @Override
    public int increaseViewCnt(Integer event_id) {
        return session.update(namespace+"increaseViewCnt", event_id);
    }

    @Override
    public List<EventDto> selectEventPage(Map map) throws Exception {
        return session.selectList(namespace+"selectEventPage", map);
    }

}
