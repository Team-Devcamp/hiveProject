package com.spring.miniproject.service;

import com.spring.miniproject.dao.EventDao;
import com.spring.miniproject.domain.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Override
    public List<EventDto> getAllEvent() throws Exception {
        return eventDao.selectAllEvent();
    }

    @Override
    public EventDto readEvent(Integer event_id) throws Exception {
        EventDto eventDto = eventDao.selectEvent(event_id);
        eventDao.increaseViewCnt(event_id);
        return eventDto;
    }

    @Override
    public int getCountEvent() throws Exception {
        return eventDao.countEvent();
    }

    @Override
    public int removeEvent(Integer event_id) throws Exception {
        return eventDao.deleteEvent(event_id);
    }

    @Override
    public int writeEvent(EventDto eventDto) throws Exception {
        return eventDao.insertEvent(eventDto);
    }

    @Override
    public int modifyEvent(EventDto eventDto) throws Exception {
        return eventDao.updateEvent(eventDto);
    }

    @Override
    public List<EventDto> getEventPage(Map map) throws Exception {
        return eventDao.selectEventPage(map);
    }

}
