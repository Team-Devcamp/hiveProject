package com.spring.miniproject.dao;

import com.spring.miniproject.domain.EventDto;

import java.util.List;
import java.util.Map;

public interface EventDao {
    List<EventDto> selectAllEvent() throws Exception;

    EventDto selectEvent(Integer event_id) throws Exception;

    int countEvent() throws Exception;

    int deleteEvent(Integer event_id) throws Exception;

    int insertEvent(EventDto eventDto) throws Exception;

    int updateEvent(EventDto eventDto) throws Exception;

    int increaseViewCnt(Integer event_id);

    List<EventDto> selectEventPage(Map map) throws Exception;
}
